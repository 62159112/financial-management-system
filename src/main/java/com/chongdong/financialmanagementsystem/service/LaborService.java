package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_labor(人工成本条目)】的数据库操作Service
* @createDate 2023-08-03 15:36:49
*/
public interface LaborService extends IService<Labor> {
    ResponseMap addLabor(Labor labor);

    ResponseMap updateLabor(Labor labor);

    ResponseMap deleteLabor(Integer id);

    ResponseMap getLabor(Integer id);

    ResponseMap listLabor(Integer page,Integer size);

    ResponseMap searchLabor(SearchModel searchModel);

    Boolean updateWithPayment(Labor labor);

    Boolean deleteWithPayment(Labor labor);

    ResponseMap countLabor();

    List<Labor> exportList(Integer page, Integer size);

    List<Labor> searchList(SearchModel searchModel);
}
