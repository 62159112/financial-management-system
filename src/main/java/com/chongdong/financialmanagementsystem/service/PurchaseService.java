package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_purchase(购置条目)】的数据库操作Service
* @createDate 2023-08-05 09:37:22
*/
public interface PurchaseService extends IService<Purchase> {
    ResponseMap addPurchase(Purchase purchase);

    ResponseMap updatePurchase(Purchase purchase);

    ResponseMap deletePurchase(Integer id);

    ResponseMap getPurchase(Integer id);

    ResponseMap listPurchase(Integer page,Integer size);

    ResponseMap searchPurchase(SearchModel searchModel);

    Boolean updateWithPayment(Purchase purchase);

    Boolean deleteWithPayment(Purchase purchase);

    ResponseMap countPurchase();

    List<Purchase> exportList(Integer page, Integer size);

    List<Purchase> searchList(SearchModel searchModel);
}
