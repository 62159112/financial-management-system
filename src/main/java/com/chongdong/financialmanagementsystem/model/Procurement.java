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
 * 采购条目
 * @TableName tcd_procurement
 */
@TableName(value ="tcd_procurement")
@Data
public class Procurement implements Serializable {
    /**
     * 采购条目编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 采购条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    private String name;

    /**
     * 采购条目类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    private String type;

    /**
     * 采购条目总价
     */
    @ExcelProperty("采购总价")
    @ColumnWidth(25)
    private BigDecimal amount;

    /**
     * 采购条目数量
     */
    @ExcelProperty("采购数量")
    @ColumnWidth(25)
    private Integer quantity;

    /**
     * 采购条目采购时间
     */
    @ExcelProperty("采购时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    private Date createTime;

    /**
     * 采购人
     */
    @ExcelProperty("采购人")
    @ColumnWidth(30)
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}