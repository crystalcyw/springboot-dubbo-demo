package com.robert.poi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;

/**
 * @author changyuwei
 * @date 2019-10-31
 */
@ExcelTarget("excelEntity")
public class ExcelEntity implements Serializable {

  private static final long serialVersionUID = -6168337737117593668L;

  @Excel(name = "")
  private Long id;

  private String name;
}
