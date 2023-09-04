package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.PurchaseService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Resource
    PurchaseService purchaseService;

    @GetMapping("/{id}")
    public ResponseMap getPurchase(@PathVariable Integer id){
        return purchaseService.getPurchase(id);
    }

    @PostMapping
    public ResponseMap addPurchase(@Validated({Purchase.AddGroup.class})@RequestBody Purchase purchase, BindingResult bindingResult){
        return purchaseService.addPurchase(purchase,bindingResult);
    }

    @PutMapping
    public ResponseMap updatePurchase(@Validated({Purchase.UpdateGroup.class})@RequestBody Purchase purchase, BindingResult bindingResult){
        return purchaseService.updatePurchase(purchase,bindingResult);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deletePurchase(@PathVariable Integer id){
        return purchaseService.deletePurchase(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listPurchase(@PathVariable  Integer page,@PathVariable Integer size){
        return purchaseService.listPurchase(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchPurchase(@RequestBody SearchModel searchModel){
        return purchaseService.searchPurchase(searchModel);
    }
    @GetMapping("/count")
    public ResponseMap countPurchase(){
        return purchaseService.countPurchase();
    }

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"购置列表");
        EasyExcel.write(response.getOutputStream(), Purchase.class).sheet("购置列表").doWrite(purchaseService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"购置列表");
        EasyExcel.write(response.getOutputStream(), Purchase.class).sheet("购置列表").doWrite(purchaseService.searchList(searchModel));
    }
}
