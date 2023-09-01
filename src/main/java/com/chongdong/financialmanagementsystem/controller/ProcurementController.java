package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.Procurement;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.ProcurementService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/procurement")
public class ProcurementController {
    @Resource
    ProcurementService procurementService;

    @GetMapping("/{id}")
    public ResponseMap getProcurement(@PathVariable Integer id){
        return procurementService.getProcurement(id);
    }

    @PostMapping
    public ResponseMap addProcurement(@RequestBody Procurement Procurement){
        return procurementService.addProcurement(Procurement);
    }

    @PutMapping
    public ResponseMap updateProcurement(@RequestBody Procurement Procurement){
        return procurementService.updateProcurement(Procurement);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deleteProcurement(@PathVariable Integer id){
        return procurementService.deleteProcurement(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listProcurement(@PathVariable  Integer page,@PathVariable Integer size){
        return procurementService.listProcurement(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchProcurement(@RequestBody SearchModel searchModel){
        return procurementService.searchProcurement(searchModel);
    }
    @GetMapping("/count")
    public ResponseMap countProcurement(){
        return procurementService.countProcurement();
    }

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"采购列表");
        EasyExcel.write(response.getOutputStream(), Procurement.class).sheet("采购列表").doWrite(procurementService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"采购列表");
        EasyExcel.write(response.getOutputStream(),Procurement.class).sheet("采购列表").doWrite(procurementService.searchList(searchModel));
    }
}
