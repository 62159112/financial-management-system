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
 * 收入条目
 * @TableName tcd_income
 */
@TableName(value ="tcd_income")
@Data
public class Income implements Serializable {
    /**
     * 收入条目编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 收入条目名称
     */
    private String name;

    /**
     * 收入条目类型
     */
    private String type;

    /**
     * 收入条目金额
     */
    private BigDecimal amount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 负责人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}