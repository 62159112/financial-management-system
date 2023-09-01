package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.Expenses;
import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.ExpensesService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"费用支出列表");
        EasyExcel.write(response.getOutputStream(), Expenses.class).sheet("费用支出列表").doWrite(expensesService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"费用支出列表");
        EasyExcel.write(response.getOutputStream(), Expenses.class).sheet("费用支出列表").doWrite(expensesService.searchList(searchModel));
    }
}
