package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Income;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;

/**
* @author cd
* @description 针对表【tcd_income(收入条目)】的数据库操作Service
* @createDate 2023-08-03 14:41:11
*/
public interface IncomeService extends IService<Income> {
    Boolean addOtherWithIncome(Income income);

    Boolean updateOtherWithIncome(Income income);

    Boolean deleteOtherWithIncome(Income income);

    ResponseMap addIncome(Income income);

    ResponseMap updateIncome(Income income);

    ResponseMap deleteIncome(Integer id);

    ResponseMap getIncome(Integer id);

    ResponseMap listIncome(Integer page,Integer size);

    ResponseMap searchIncome(SearchModel searchModel);

    ResponseMap countIncome();
}
