package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Income;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import com.chongdong.financialmanagementsystem.utils.IncomeUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/income")
public class IncomeController {
    @Resource
    IncomeService incomeService;
    @Resource
    IncomeUtil incomeUtil;

    @GetMapping("/{id}")
    public ResponseMap getIncome(@PathVariable Integer id){
        return incomeService.getIncome(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listIncome(@PathVariable Integer page, @PathVariable Integer size){
        return incomeService.listIncome(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchIncome(@RequestBody SearchModel searchModel){
        return incomeService.searchIncome(searchModel);
    }

    @PutMapping
    public Boolean updateIncome(@RequestBody Income income){
        return incomeUtil.updateIncomeWithOther(income);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteIncome(@PathVariable Integer id){
        return incomeUtil.deleteIncomeWithOther(id);
    }

    @GetMapping("/count")
    public ResponseMap countIncome(){
        return incomeService.countIncome();
    }
}
