package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Expenses;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.ExpensesService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    @Resource
    ExpensesService expensesService;

    @GetMapping("/{id}")
    public ResponseMap getExpenses(@PathVariable Integer id){
        return expensesService.getExpenses(id);
    }

    @PostMapping
    public ResponseMap addExpenses(@RequestBody Expenses expenses){
        return expensesService.addExpenses(expenses);
    }

    @PutMapping
    public ResponseMap updateExpenses(@RequestBody Expenses expenses){
        return expensesService.updateExpenses(expenses);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deleteExpenses(@PathVariable Integer id){
        return expensesService.deleteExpenses(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listExpenses(@PathVariable  Integer page,@PathVariable Integer size){
        return expensesService.listExpenses(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchExpenses(@RequestBody SearchModel searchModel){
        return expensesService.searchExpenses(searchModel);
    }
    @GetMapping("/count")
    public ResponseMap countExpenses(){
        return expensesService.countExpenses();
    }
}
