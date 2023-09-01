package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.Purchase;
import com.chongdong.financialmanagementsystem.model.Reimbursement;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.ReimbursementService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {
    @Resource
    ReimbursementService reimbursementService;

    @GetMapping("/{id}")
    public ResponseMap getReimbursement(@PathVariable Integer id){
        return reimbursementService.getReimbursement(id);
    }

    @PostMapping
    public ResponseMap addReimbursement(@RequestBody Reimbursement reimbursement){
        return reimbursementService.addReimbursement(reimbursement);
    }

    @PutMapping
    public ResponseMap updateReimbursement(@RequestBody Reimbursement reimbursement){
        return reimbursementService.updateReimbursement(reimbursement);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deleteReimbursement(@PathVariable Integer id){
        return reimbursementService.deleteReimbursement(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listReimbursement(@PathVariable  Integer page,@PathVariable Integer size){
        return reimbursementService.listReimbursement(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchReimbursement(@RequestBody SearchModel searchModel){
        return reimbursementService.searchReimbursement(searchModel);
    }
    @GetMapping("/count")
    public ResponseMap countReimbursement(){
        return reimbursementService.countReimbursement();
    }

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"报销列表");
        EasyExcel.write(response.getOutputStream(), Reimbursement.class).sheet("报销列表").doWrite(reimbursementService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"报销列表");
        EasyExcel.write(response.getOutputStream(), Reimbursement.class).sheet("报销列表").doWrite(reimbursementService.searchList(searchModel));
    }
}
