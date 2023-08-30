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
 * 销售出账条目
 * @TableName tcd_sale
 */
@TableName(value ="tcd_sale")
@Data
public class Sale implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 销售出账条目名称
     */
    private String name;

    /**
     * 销售出账条目类型
     */
    private String type;

    /**
     * 销售出账条目总金额
     */
    private BigDecimal amount;

    /**
     * 销售出账数量
     */
    private Integer quantity;

    /**
     * 购买方
     */
    private String purchaser;

    /**
     * 购买时间
     */
    private Date createTime;

    /**
     * 负责人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}