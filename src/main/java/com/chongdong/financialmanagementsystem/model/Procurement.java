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
 * 采购条目
 * @TableName tcd_procurement
 */
@TableName(value ="tcd_procurement")
@Data
public class Procurement implements Serializable {
    /**
     * 采购条目编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 采购条目名称
     */
    private String name;

    /**
     * 采购条目类型
     */
    private String type;

    /**
     * 采购条目总价
     */
    private BigDecimal amount;

    /**
     * 采购条目数量
     */
    private Integer quantity;

    /**
     * 采购条目采购时间
     */
    private Date createTime;

    /**
     * 采购人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}