package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    List<Expenses> exportList(Integer page, Integer size);

    List<Expenses> searchList(SearchModel searchModel);
}
