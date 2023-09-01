package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_reimbursement(报销条目)】的数据库操作Service
* @createDate 2023-08-03 15:37:01
*/
public interface ReimbursementService extends IService<Reimbursement> {
    ResponseMap addReimbursement(Reimbursement reimbursement);

    ResponseMap updateReimbursement(Reimbursement reimbursement);

    ResponseMap deleteReimbursement(Integer id);

    ResponseMap getReimbursement(Integer id);

    ResponseMap listReimbursement(Integer page,Integer size);

    ResponseMap searchReimbursement(SearchModel searchModel);

    Boolean updateWithPayment(Reimbursement reimbursement);

    Boolean deleteWithPayment(Reimbursement reimbursement);

    ResponseMap countReimbursement();

    List<Reimbursement> exportList(Integer page, Integer size);

    List<Reimbursement> searchList(SearchModel searchModel);
}
