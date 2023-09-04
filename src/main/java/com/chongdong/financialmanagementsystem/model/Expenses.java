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
 * 费用支出条目
 * @TableName tcd_expenses
 */
@TableName(value ="tcd_expenses")
@Data
public class Expenses implements Serializable {
    public interface AddGroup{}
    public interface UpdateGroup{}
    /**
     * 费用支出条目编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    @NotNull(message = "条目id不能为空" , groups = {UpdateGroup.class})
    @Null(message = "条目id自动生成，不要求传递", groups = {AddGroup.class})
    private Integer id;

    /**
     * 费用支出条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    @NotNull(message = "条目名称不能为空" , groups = {AddGroup.class})
    @Length(min = 2,max = 20, message = "条目名称要求在{min}-{max}之间" , groups = {AddGroup.class,UpdateGroup.class})
    private String name;

    /**
     * 费用支出条目类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    @NotNull(message = "类型不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "类型名称要求在{min}-{max}之间", groups = {AddGroup.class,UpdateGroup.class} )
    private String type;

    /**
     * 费用支出条目金额
     */
    @ExcelProperty("支出金额")
    @ColumnWidth(25)
    @NotNull(message = "金额不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Range(min = 0,max = 9999999,message = "金额要求在{min}-{max}之间" ,groups = {AddGroup.class,UpdateGroup.class})
    private BigDecimal amount;

    /**
     * 费用支出条目地点
     */
    @ExcelProperty("支出地点")
    @ColumnWidth(25)
    @NotNull(message = "支出地点不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "支出地点名称要求在{min}-{max}之间" , groups = {AddGroup.class,UpdateGroup.class})
    private String address;

    /**
     * 费用支出条目创建时间
     */
    @ExcelProperty("创建时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    @Null(message = "创建时间要求为空")
    private Date createTime;

    /**
     * 费用支出条目支出人
     */
    @ExcelProperty("支出人")
    @ColumnWidth(30)
    @NotNull(message = "支出人不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "支出人名称要求在{min}-{max}之间" , groups = {AddGroup.class,UpdateGroup.class})
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}