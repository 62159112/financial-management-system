package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_payment(支出条目)】的数据库操作Service
* @createDate 2023-08-04 15:13:59
*/
public interface PaymentService extends IService<Payment> {
    Boolean addOtherWithPayment(Payment payment);

    Boolean updateOtherWithPayment(Payment payment);

    Boolean deleteOtherWithPayment(Payment payment);

    ResponseMap addPayment(Payment payment);

    ResponseMap updatePayment(Payment payment);

    ResponseMap deletePayment(Integer id);

    ResponseMap getPayment(Integer id);

    ResponseMap listPayment(Integer page, Integer size);

    ResponseMap searchPayment(SearchModel searchModel);

    ResponseMap countPayment();

    List<Payment> exportList(Integer page, Integer size);

    List<Payment> searchList(SearchModel searchModel);
}