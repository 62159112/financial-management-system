package com.chongdong.financialmanagementsystem.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * 采购条目
 * @TableName tcd_procurement
 */
@TableName(value ="tcd_procurement")
@Data
public class Procurement implements Serializable {
    public interface AddGroup{}
    public interface UpdateGroup{}
    /**
     * 采购条目编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    @NotNull(message = "条目id不能为空" , groups = {UpdateGroup.class})
    @Null(message = "条目id自动生成，不要求传递", groups = {AddGroup.class})
    private Integer id;

    /**
     * 采购条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    @NotNull(message = "条目名称不能为空" , groups = {AddGroup.class})
    @Length(min = 2,max = 20, message = "条目名称要求在{min}-{max}之间", groups = {AddGroup.class,UpdateGroup.class} )
    private String name;

    /**
     * 采购条目类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    @NotNull(message = "类型不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "类型名称要求在{min}-{max}之间", groups = {AddGroup.class,UpdateGroup.class} )
    private String type;

    /**
     * 采购条目总价
     */
    @ExcelProperty("采购总价")
    @ColumnWidth(25)
    @NotNull(message = "总价不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Range(min = 0,max = 9999999,message = "总价要求在{min}-{max}之间" ,groups = {AddGroup.class,UpdateGroup.class})
    private BigDecimal amount;

    /**
     * 采购条目数量
     */
    @ExcelProperty("采购数量")
    @ColumnWidth(25)
    @NotNull(message = "数量不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Range(min = 0,max = 999,message = "数量要求在{min}-{max}之间" ,groups = {AddGroup.class,UpdateGroup.class})
    private Integer quantity;

    /**
     * 采购条目采购时间
     */
    @ExcelProperty("采购时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    @Null(message = "创建时间要求为空")
    private Date createTime;

    /**
     * 采购人
     */
    @ExcelProperty("采购人")
    @ColumnWidth(30)
    @NotNull(message = "采购人不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "采购人名称要求在{min}-{max}之间" , groups = {AddGroup.class,UpdateGroup.class})
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}