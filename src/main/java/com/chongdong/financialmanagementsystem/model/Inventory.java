package com.chongdong.financialmanagementsystem.model;

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
    private Integer id;

    /**
     * 库存条目名称
     */
    private String name;

    /**
     * 库存条目类型
     */
    private String type;

    /**
     * 库存总量
     */
    private Integer total;

    /**
     * 已使用数量
     */
    private Integer usedQuantity;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 负责人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}