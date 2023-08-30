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
 * 运营成本条目
 * @TableName tcd_operate
 */
@TableName(value ="tcd_operate")
@Data
public class Operate implements Serializable {
    /**
     * 运营成本条目编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 运营成本条目名称
     */
    private String name;

    /**
     * 运营成本条目类型
     */
    private String type;

    /**
     * 运营成本条目支出金额
     */
    private BigDecimal amount;

    /**
     * 运营成本条目支出时间
     */
    private Date createTime;

    /**
     * 运营成本条目负责人
     */
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}