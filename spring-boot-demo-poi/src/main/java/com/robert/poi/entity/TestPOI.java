package com.robert.poi.entity;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author changyuwei
 * @date 2019-10-31
 */
public class TestPOI {

  public static void main(String[] args) {
//    ExcelWriter writer = ExcelUtil.getWriter();
//    writer.write();
//
//    ExcelExportUtil.exportExcel();

    System.out.println(StandardCharsets.UTF_8.displayName());
    System.out.println(StandardCharsets.UTF_8.name());
  }
}
