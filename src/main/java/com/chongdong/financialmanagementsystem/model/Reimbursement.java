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

/**
 * 报销条目
 * @TableName tcd_reimbursement
 */
@TableName(value ="tcd_reimbursement")
@Data
public class Reimbursement implements Serializable {
    public interface AddGroup{}
    public interface UpdateGroup{}
    /**
     * 报销条目编号

     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    @NotNull(message = "条目id不能为空" , groups = {UpdateGroup.class})
    @Null(message = "条目id自动生成，不要求传递", groups = {AddGroup.class})
    private Integer id;

    /**
     * 报销条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    @NotNull(message = "条目名称不能为空" , groups = {AddGroup.class})
    @Length(min = 2,max = 20, message = "条目名称要求在{min}-{max}之间", groups = {AddGroup.class,UpdateGroup.class} )
    private String name;

    /**
     * 报销条目类别
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    @NotNull(message = "类型不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "类型名称要求在{min}-{max}之间", groups = {AddGroup.class,UpdateGroup.class} )
    private String type;

    /**
     * 报销条目金额
     */
    @ExcelProperty("支出金额")
    @ColumnWidth(25)
    @NotNull(message = "金额不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    private BigDecimal amount;

    /**
     * 报销条目时间
     */
    @ExcelProperty("支出时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    @Null(message = "创建时间要求为空")
    private Date createTime;

    /**
     * 报销条目申请人
     */
    @ExcelProperty("申请人")
    @ColumnWidth(30)
    @NotNull(message = "申请人不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "申请人名称要求在{min}-{max}之间", groups = {AddGroup.class,UpdateGroup.class} )
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}