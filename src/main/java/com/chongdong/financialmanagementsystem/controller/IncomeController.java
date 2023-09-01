package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import com.chongdong.financialmanagementsystem.utils.IncomeUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    @PostMapping
    public ResponseMap addIncome(@RequestBody Income income){
        return incomeService.addIncome(income);
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

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"收入列表");
        EasyExcel.write(response.getOutputStream(), Income.class).sheet("收入列表").doWrite(incomeService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"收入列表");
        EasyExcel.write(response.getOutputStream(), Income.class).sheet("收入列表").doWrite(incomeService.searchList(searchModel));
    }
}
