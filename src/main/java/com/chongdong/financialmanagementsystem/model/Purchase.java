package com.chongdong.financialmanagementsystem.model;

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
    private Integer id;

    /**
     * 购置条目物品名称
     */
    private String name;

    /**
     * 购置物品类型
     */
    private String type;

    /**
     * 购置条目物品金额
     */
    private BigDecimal amount;

    /**
     * 购置物品数量
     */
    private Integer quantity;

    /**
     * 购置条目购置时间
     */
    private Date createTime;

    /**
     * 购置条目购置人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}