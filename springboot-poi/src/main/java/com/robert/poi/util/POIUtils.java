package com.robert.poi.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.Base64Utils;

/**
 * @author changyuwei
 * @date 2019-10-31
 */
public final class POIUtils {

    private static final String BROWSER_FIREFOX = "firefox";

    private POIUtils() {
    }

    /**
     * 下载 Excel
     *
     * @param fileName 文件名
     * @param workbook workbook
     * @param response 响应
     */
    public static void downloadExcel(String fileName, Workbook workbook, HttpServletRequest request,
        HttpServletResponse response) {
        OutputStream os = null;
        try {
            // 设置响应编码
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            // 告诉浏览器什么软件可以打开此文件
            response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
            // 设置浏览器响应头对应的 Content-Disposition
            //判断是不是火狐浏览器
            String browser = request.getHeader("User-Agent");
            if (Objects.nonNull(browser) && browser.toLowerCase().contains(BROWSER_FIREFOX)) {
                fileName = "=?UTF-8?B?" + (Base64Utils
                    .encodeToString(fileName.getBytes(StandardCharsets.UTF_8))) + "?=";
            } else {
                fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name());
            }
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            os = response.getOutputStream();
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
