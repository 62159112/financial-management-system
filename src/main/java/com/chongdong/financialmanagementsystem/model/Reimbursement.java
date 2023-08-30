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
 * 报销条目
 * @TableName tcd_reimbursement
 */
@TableName(value ="tcd_reimbursement")
@Data
public class Reimbursement implements Serializable {
    /**
     * 报销条目编号

     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 报销条目名称
     */
    private String name;

    /**
     * 报销条目类别
     */
    private String type;

    /**
     * 报销条目金额
     */
    private BigDecimal amount;

    /**
     * 报销条目时间
     */
    private Date createTime;

    /**
     * 报销条目申请人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}