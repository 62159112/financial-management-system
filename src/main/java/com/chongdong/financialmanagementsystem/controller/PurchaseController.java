package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Purchase;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.PurchaseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    public ResponseMap addPurchase(@RequestBody Purchase purchase){
        return purchaseService.addPurchase(purchase);
    }

    @PutMapping
    public ResponseMap updatePurchase(@RequestBody Purchase purchase){
        return purchaseService.updatePurchase(purchase);
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
}
