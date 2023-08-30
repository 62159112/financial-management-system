package com.chongdong.financialmanagementsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 管理员
 * @TableName tcd_administrators
 */
@TableName(value ="tcd_administrators")
@Data
public class Administrators implements Serializable {
    /**
     * 管理员编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 管理员用户名

     */
    private String username;

    /**
     * 管理员密码
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}