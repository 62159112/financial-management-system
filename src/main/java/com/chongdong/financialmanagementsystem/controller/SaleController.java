package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Sale;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.SaleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    public ResponseMap addSale(@RequestBody Sale sale){
        return saleService.addSale(sale);
    }

    @PutMapping
    public ResponseMap updateSale(@RequestBody Sale sale){
        return saleService.updateSale(sale);
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
}
