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
 * 库存条目
 * @TableName tcd_inventory
 */
@TableName(value ="tcd_inventory")
@Data
public class Inventory implements Serializable {
    /**
     * 库存条目编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 库存条目名称
     */
    @ExcelProperty("库存条目名称")
    @ColumnWidth(35)
    private String name;

    /**
     * 库存条目类型
     */
    @ExcelProperty("库存条目类型")
    @ColumnWidth(35)
    private String type;

    /**
     * 库存总量
     */
    @ExcelProperty("库存总量")
    @ColumnWidth(35)
    private Integer total;

    /**
     * 已使用数量
     */
    @ExcelProperty("已使用数量")
    @ColumnWidth(35)
    private Integer usedQuantity;

    /**
     * 修改时间
     */
    @ExcelProperty("时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(35)
    private Date updateTime;

    /**
     * 负责人
     */
    @ExcelProperty("负责人")
    @ColumnWidth(35)
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}