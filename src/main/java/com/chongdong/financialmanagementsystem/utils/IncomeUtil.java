package com.chongdong.financialmanagementsystem.utils;

import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.Sale;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import com.chongdong.financialmanagementsystem.service.SaleService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomeUtil {
    @Resource
    SaleService saleService;
    @Resource
    IncomeService incomeService;

    Income income = EntityFactory.createIncome();
    Sale sale = EntityFactory.createSale();

    @Transactional
    public Boolean updateIncomeWithOther(Income income){
        Income oldIncome = incomeService.getById(income.getId());
        switch (oldIncome.getType()){
            case "销售出账" -> {
                BeanUtils.copyProperties(sale, income);
                sale.setId(null);
                sale.setType(null);
                return saleService.updateWithIncome(sale) && incomeService.updateById(income);
            }
            case "其它" -> {
                return incomeService.updateById(income);
            }
        }
        return false;
    }

    @Transactional
    public Boolean deleteIncomeWithOther(Integer id){
        Income oldIncome = incomeService.getById(id);
        switch (oldIncome.getType()){
            case "销售出账" -> {
                BeanUtils.copyProperties(sale, income);
                sale.setId(null);
                sale.setType(null);
                return saleService.deleteWithIncome(sale) && incomeService.removeById(income);
            }
            case "其它" -> {
                return incomeService.removeById(income);
            }
        }
        return false;
    }
}
