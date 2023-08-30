package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Expenses;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;

/**
* @author cd
* @description 针对表【tcd_expenses(费用支出条目)】的数据库操作Service
* @createDate 2023-08-03 17:04:45
*/
public interface ExpensesService extends IService<Expenses> {
    ResponseMap addExpenses(Expenses expenses);

    ResponseMap updateExpenses(Expenses expenses);

    ResponseMap deleteExpenses(Integer id);

    ResponseMap getExpenses(Integer id);

    ResponseMap listExpenses(Integer page,Integer size);

    ResponseMap searchExpenses(SearchModel searchModel);

    Boolean updateWithPayment(Expenses expenses);

    Boolean deleteWithPayment(Expenses expenses);

    ResponseMap countExpenses();
}
