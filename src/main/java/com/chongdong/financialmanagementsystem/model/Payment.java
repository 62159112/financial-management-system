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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支出条目
 * @TableName tcd_payment
 */
@TableName(value ="tcd_payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     * 支出编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 支出名称
     */
    @ExcelProperty("支出名称")
    @ColumnWidth(35)
    private String name;

    /**
     * 支出类别
     */
    @ExcelProperty("支出类别")
    @ColumnWidth(25)
    private String type;

    /**
     * 支出金额
     */
    @ExcelProperty("支出金额")
    @ColumnWidth(25)
    private BigDecimal amount;

    /**
     * 支出时间
     */
    @ExcelProperty("支出时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    private Date createTime;

    /**
     * 负责人
     */
    @ExcelProperty("负责人")
    @ColumnWidth(30)
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}