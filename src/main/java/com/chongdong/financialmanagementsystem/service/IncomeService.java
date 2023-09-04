package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_income(收入条目)】的数据库操作Service
* @createDate 2023-08-03 14:41:11
*/
public interface IncomeService extends IService<Income> {
    Boolean addOtherWithIncome(Income income);

    Boolean updateOtherWithIncome(Income income);

    Boolean deleteOtherWithIncome(Income income);

    ResponseMap addIncome(Income income, BindingResult bindingResult);

    ResponseMap updateIncome(Income income);

    ResponseMap deleteIncome(Integer id);

    ResponseMap getIncome(Integer id);

    ResponseMap listIncome(Integer page,Integer size);

    ResponseMap searchIncome(SearchModel searchModel);

    ResponseMap countIncome();

    List<Income> exportList(Integer page, Integer size);

    List<Income> searchList(SearchModel searchModel);
}
