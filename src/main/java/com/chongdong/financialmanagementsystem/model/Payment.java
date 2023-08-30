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
 * 支出条目
 * @TableName tcd_payment
 */
@TableName(value ="tcd_payment")
@Data
public class Payment implements Serializable {
    /**
     * 支出编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 支出名称
     */
    private String name;

    /**
     * 支出类别
     */
    private String type;

    /**
     * 支出金额
     */
    private BigDecimal amount;

    /**
     * 支出时间
     */
    private Date createTime;

    /**
     * 负责人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}