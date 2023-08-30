package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Procurement;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.ProcurementService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
}
