package com.chongdong.financialmanagementsystem.controller;


import com.chongdong.financialmanagementsystem.model.Inventory;
import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Resource
    InventoryService inventoryService;

    //id查询
    @GetMapping("/{id}")
    public ResponseMap getInventory(@PathVariable Integer id){
        return inventoryService.getInventory(id);
    }

    //添加
    @PostMapping("/add")
    public ResponseMap addInventory(@RequestBody Inventory inventory){
        return inventoryService.addInventory(inventory);
    }

    //修改
    @PutMapping
    public ResponseMap updateInventory(@RequestBody Inventory inventory){
        return inventoryService.updateInventory(inventory);
    }

    //删除
    @DeleteMapping("/{id}")
    public ResponseMap deleteInventory(@PathVariable Integer id){
        return inventoryService.deleteInventory(id);
    }


    @GetMapping("/list/{page}/{size}")
    public ResponseMap listInventory(@PathVariable Integer page, @PathVariable Integer size){
        return inventoryService.listInventory(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchInventory(@RequestBody SearchModel searchModel){
        return inventoryService.searchInventory(searchModel);
    }


}
