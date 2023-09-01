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
 * 购置条目
 * @TableName tcd_purchase
 */
@TableName(value ="tcd_purchase")
@Data
public class Purchase implements Serializable {
    /**
     * 购置条目编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 购置条目物品名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    private String name;

    /**
     * 购置物品类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    private String type;

    /**
     * 购置条目物品金额
     */
    @ExcelProperty("物品金额")
    @ColumnWidth(25)
    private BigDecimal amount;

    /**
     * 购置物品数量
     */
    @ExcelProperty("购置数量")
    @ColumnWidth(25)
    private Integer quantity;

    /**
     * 购置条目购置时间
     */
    @ExcelProperty("购置时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    private Date createTime;

    /**
     * 购置条目购置人
     */
    @ExcelProperty("购置人")
    @ColumnWidth(30)
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}