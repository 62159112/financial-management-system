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
import java.util.Date;
import lombok.Data;

/**
 * 库存物品使用详情
 * @TableName tcd_inventory_usage
 */
@TableName(value ="tcd_inventory_usage")
@Data
public class InventoryUsage implements Serializable {
    /**
     * 物品使用详情编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 使用人
     */
    @ExcelProperty("使用人")
    @ColumnWidth(35)
    private String user;

    /**
     * 使用数量
     */
    @ExcelProperty("使用数量")
    @ColumnWidth(35)
    private Integer quantity;

    /**
     * 使用时间	
     */
    @ExcelProperty("使用时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(35)
    private Date createTime;

    /**
     * 备注
     */
    @ExcelProperty("备注")
    @ColumnWidth(35)
    private String remark;

    /**
     * 物品名称
     */
    @ExcelProperty("物品名称")
    @ColumnWidth(35)
    private String article;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}