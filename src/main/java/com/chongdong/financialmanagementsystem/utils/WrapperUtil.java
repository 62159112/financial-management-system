package com.chongdong.financialmanagementsystem.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlLike;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
public class WrapperUtil<T> {
    public QueryWrapper<T> wrapperTimeDesc(){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return wrapper;
    }
    /**
     * 搜索通用
     * */
    public QueryWrapper<T> wrapperNormal(String search, String startTime, String endTime) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.apply("UNIX_TIMESTAMP(create_time) >= UNIX_TIMESTAMP('" +startTime  + "')");
        wrapper.apply("UNIX_TIMESTAMP(create_time) <= UNIX_TIMESTAMP('" +endTime  + "')");
        wrapper.like(StringUtils.hasLength(search), "name", search)
                .or().like(StringUtils.hasLength(search), "type", search)
                .or().like(StringUtils.hasLength(search), "amount", search)
                .or().like(StringUtils.hasLength(search), "director", search);
        if (StringUtils.hasLength(startTime) && StringUtils.hasLength(endTime)){
            LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }
    public QueryWrapper<T> wrapperLike(String search){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.hasLength(search), "name", search)
                .or().like(StringUtils.hasLength(search), "type", search)
                .or().like(StringUtils.hasLength(search), "amount", search)
                .or().like(StringUtils.hasLength(search), "director", search);
        return wrapper;
    }
    public QueryWrapper<T> wrapperTimeSlot( String startTime, String endTime){
        String start = startTime.contains("/") ? startTime.replaceAll("/", "-") : startTime;
        String end = endTime.contains("/") ? endTime.replaceAll("/", "-") : endTime;
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.apply("UNIX_TIMESTAMP(create_time) >= UNIX_TIMESTAMP('" + start + "')");
        wrapper.apply("UNIX_TIMESTAMP(create_time) <= UNIX_TIMESTAMP('" + end + "')");
        wrapper.orderByDesc("create_time");
        return wrapper;
    }
    public QueryWrapper<T> wrapperNormal11(String search, String startTime, String endTime) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(startTime) && StringUtils.hasLength(endTime)){
            LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            wrapper.between("update_time", start, end);
        }
        wrapper.like(StringUtils.hasLength(search), "name", search)
                .or().like(StringUtils.hasLength(search), "type", search)
                .or().like(StringUtils.hasLength(search), "total", search)
                .or().like(StringUtils.hasLength(search), "director", search);
        wrapper.orderByDesc("update_time");
        return wrapper;
    }


    public QueryWrapper<T> wrapperNormal22(String search, String startTime, String endTime) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(startTime) && StringUtils.hasLength(endTime)){
            LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            wrapper.between("create_time", start, end);
        }
        wrapper.like(StringUtils.hasLength(search), "user", search)
                .or().like(StringUtils.hasLength(search), "article", search)
                .or().like(StringUtils.hasLength(search), "remark", search)
                .or().like(StringUtils.hasLength(search), "quantity", search);
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    public QueryWrapper<T> wrapperNormal33(String search, String startTime, String endTime) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(startTime) && StringUtils.hasLength(endTime)){
            LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            wrapper.between("create_time", start, end);
        }
        wrapper.eq(StringUtils.hasLength(search), "article", search)
                .or().like(StringUtils.hasLength(search), "user", search)
                .or().like(StringUtils.hasLength(search), "remark", search)
                .or().like(StringUtils.hasLength(search), "quantity", search);
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    public QueryWrapper<T> wrapperNormal44(String search, String startTime, String endTime) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(startTime) && StringUtils.hasLength(endTime)){
            LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            wrapper.between("create_time", start, end);
        }
        wrapper.like(StringUtils.hasLength(search), "article", search)
                .or().like(StringUtils.hasLength(search), "user", search)
                .or().like(StringUtils.hasLength(search), "remark", search)
                .or().like(StringUtils.hasLength(search), "quantity", search);
        wrapper.orderByDesc("create_time");
        return wrapper;
    }




    /**
     * 获取单个
     * */
    public QueryWrapper<T> wrapperGetOne(String name, Date createTime){
        LocalDateTime localDateTime = createTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(name),"name",name);
        wrapper.eq("create_time",localDateTime);
        return wrapper;
    }
    /**
     * 费用支出搜索使用
     * */
    public QueryWrapper<T> wrapperExpenses(String search, String startTime, String endTime){
        QueryWrapper<T> wrapper = wrapperNormal(search, startTime, endTime);
        wrapper.or().like(StringUtils.hasLength(search), "address", search);
        return wrapper;
    }
    /**
     * 库存条目搜索使用
     * */
    public QueryWrapper<T> wrapperInventory(String search, String startTime, String endTime){
        QueryWrapper<T> wrapper = wrapperNormal(search, startTime, endTime);
        wrapper.or().like(StringUtils.hasLength(search), "total", search)
                .or().like(StringUtils.hasLength(search), "used_quantity", search);
        return wrapper;
    }
    /**
     * 采购条目搜索使用
     * */
    public QueryWrapper<T> wrapperProcurement(String search, String startTime, String endTime){
        QueryWrapper<T> wrapper = wrapperNormal(search, startTime, endTime);
        wrapper.or().like(StringUtils.hasLength(search), "quantity", search);
        return wrapper;
    }
    /**
     * 销售条目搜索使用
     * */
    public QueryWrapper<T> wrapperSale(String search, String startTime, String endTime){
        QueryWrapper<T> wrapper = wrapperNormal(search, startTime, endTime);
        wrapper.or().like(StringUtils.hasLength(search), "quantity", search)
                .or().like(StringUtils.hasLength(search), "purchaser", search);
        return wrapper;
    }
    /**
     * 类型列表使用
     * */
    public QueryWrapper<T> wrapperType(Integer belong){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(String.valueOf(belong)),"type_belong",belong);
        return wrapper;
    }
    /**
     * 仓库添加修改删除使用
     * */
    public QueryWrapper<T> wrapperName(String name){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(String.valueOf(name)),"name",name);
        return wrapper;
    }
    /**
     * 按时间查询单个，子模块同步更新删除使用
     * */
    public QueryWrapper<T> wrapperTime(Date createTime){
        LocalDateTime localDateTime = createTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq("create_time",localDateTime);
        return wrapper;
    }

}
