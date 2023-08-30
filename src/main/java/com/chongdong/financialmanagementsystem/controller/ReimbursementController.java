package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Reimbursement;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.ReimbursementService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
}
