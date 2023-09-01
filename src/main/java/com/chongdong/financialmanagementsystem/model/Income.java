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
 * 收入条目
 * @TableName tcd_income
 */
@TableName(value ="tcd_income")
@Data
public class Income implements Serializable {
    /**
     * 收入条目编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 收入条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    private String name;

    /**
     * 收入条目类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    private String type;

    /**
     * 收入条目金额
     */
    @ExcelProperty("收入金额")
    @ColumnWidth(25)
    private BigDecimal amount;

    /**
     * 创建时间
     */
    @ExcelProperty("创建时间")
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