package com.robert.poi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.google.common.collect.Lists;
import com.robert.poi.entity.ExcelEntity;
import com.robert.poi.util.POIUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyuwei
 * @date 2019-12-17
 */
@RestController
public class POIController {

    @RequestMapping("/export")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        ExcelEntity entity1 = new ExcelEntity(1L, "tom");
        ExcelEntity entity2 = new ExcelEntity(2L, "jerry");
        ExcelEntity entity3 = new ExcelEntity(3L, "harry");
        ExcelEntity entity4 = new ExcelEntity(4L, "bird");
        List<ExcelEntity> data = Lists.newArrayList(entity1, entity2, entity3, entity4);
        ExportParams params = new ExportParams();
        params.setSheetName("🐱 and 🐭");
        Workbook workbook = ExcelExportUtil.exportExcel(params, ExcelEntity.class, data);
        POIUtils.downloadExcel("猫🐱和老鼠🐭.xls", workbook, request, response);
    }
}
