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
 * 费用支出条目
 * @TableName tcd_expenses
 */
@TableName(value ="tcd_expenses")
@Data
public class Expenses implements Serializable {
    /**
     * 费用支出条目编号

     */
    @TableId(type = IdType.AUTO)

    private Integer id;

    /**
     * 费用支出条目名称
     */
    private String name;

    /**
     * 费用支出条目类型
     */
    private String type;

    /**
     * 费用支出条目金额
     */
    private BigDecimal amount;

    /**
     * 费用支出条目地点
     */
    private String address;

    /**
     * 费用支出条目创建时间
     */
    private Date createTime;

    /**
     * 费用支出条目支出人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}