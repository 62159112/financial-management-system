package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.Type;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.model.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.annotation.Resource;

/**
* @author cd
* @description 针对表【tcd_type(类型管理)】的数据库操作Service
* @createDate 2023-08-03 15:37:08
*/
public interface TypeService extends IService<Type> {
    ResponseMap addType(Type type);

    ResponseMap updateType(Type type);

    ResponseMap deleteType(Integer id);

    ResponseMap listType(Integer belong,Integer page,Integer size);

    ResponseMap listTypeWithOutPage(Integer belong);

}
