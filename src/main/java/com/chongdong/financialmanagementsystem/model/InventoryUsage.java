package com.chongdong.financialmanagementsystem.model;

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
    private Integer id;

    /**
     * 使用人
     */
    private String user;

    /**
     * 使用数量
     */
    private Integer quantity;

    /**
     * 使用时间	
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 物品名称
     */
    private String article;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}