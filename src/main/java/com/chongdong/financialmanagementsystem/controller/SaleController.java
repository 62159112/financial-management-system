package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.Reimbursement;
import com.chongdong.financialmanagementsystem.model.Sale;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.SaleService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Resource
    SaleService saleService;
    
    @GetMapping("/{id}")
    public ResponseMap getSale(@PathVariable Integer id){
        return saleService.getSale(id);
    }

    @PostMapping
    public ResponseMap addSale(@Validated({Sale.AddGroup.class})@RequestBody Sale sale, BindingResult bindingResult){
        return saleService.addSale(sale,bindingResult);
    }

    @PutMapping
    public ResponseMap updateSale(@Validated({Sale.UpdateGroup.class})@RequestBody Sale sale, BindingResult bindingResult){
        return saleService.updateSale(sale,bindingResult);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deleteSale(@PathVariable Integer id){
        return saleService.deleteSale(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listSale(@PathVariable  Integer page,@PathVariable Integer size){
        return saleService.listSale(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchSale(@RequestBody SearchModel searchModel){
        return saleService.searchSale(searchModel);
    }

    @GetMapping("/count")
    public ResponseMap countSale(){
        return saleService.countSale();
    }

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"报销列表");
        EasyExcel.write(response.getOutputStream(), Sale.class).sheet("报销列表").doWrite(saleService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"报销列表");
        EasyExcel.write(response.getOutputStream(), Sale.class).sheet("报销列表").doWrite(saleService.searchList(searchModel));
    }
}
