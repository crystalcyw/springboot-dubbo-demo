package com.robert.poi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author changyuwei
 * @date 2019-10-31
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ExcelTarget("excelEntity")
public class ExcelEntity implements Serializable {

    private static final long serialVersionUID = -6168337737117593668L;

    @Excel(name = "id")
    private Long id;

    @Excel(name = "名称")
    private String name;
}
