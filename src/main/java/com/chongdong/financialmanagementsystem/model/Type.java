package com.chongdong.financialmanagementsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 类型管理
 * @TableName tcd_type
 */
@TableName(value ="tcd_type")
@Data
public class Type implements Serializable {
    /**
     * 类型编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型所属：1．支出类型 2．收入类型 3．采购类型 4．费用支出类型 5．人工成本类型 6．运营类型 7．报销类型 8．购置类型 9．销售出账类型 10．库存类型
     */
    private Integer typeBelong;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}