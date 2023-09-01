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
 * 销售出账条目
 * @TableName tcd_sale
 */
@TableName(value ="tcd_sale")
@Data
public class Sale implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 销售出账条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    private String name;

    /**
     * 销售出账条目类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    private String type;

    /**
     * 销售出账条目总金额
     */
    @ExcelProperty("收入总金额")
    @ColumnWidth(25)
    private BigDecimal amount;

    /**
     * 销售出账数量
     */
    @ExcelProperty("销售数量")
    @ColumnWidth(25)
    private Integer quantity;

    /**
     * 购买方
     */
    @ExcelProperty("购买方")
    @ColumnWidth(30)
    private String purchaser;

    /**
     * 购买时间
     */
    @ExcelProperty("购买时间")
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