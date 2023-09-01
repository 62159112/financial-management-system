package com.chongdong.financialmanagementsystem.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 费用支出条目
 * @TableName tcd_expenses
 */
@TableName(value ="tcd_expenses")
@Data
public class Expenses implements Serializable {
    /**
     * 费用支出条目编号

     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 费用支出条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    private String name;

    /**
     * 费用支出条目类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    private String type;

    /**
     * 费用支出条目金额
     */
    @ExcelProperty("支出金额")
    @ColumnWidth(25)
    private BigDecimal amount;

    /**
     * 费用支出条目地点
     */
    @ExcelProperty("支出地点")
    @ColumnWidth(25)
    private String address;

    /**
     * 费用支出条目创建时间
     */
    @ExcelProperty("创建时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    private Date createTime;

    /**
     * 费用支出条目支出人
     */
    @ExcelProperty("支出人")
    @ColumnWidth(30)
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}