package com.chongdong.financialmanagementsystem.controller;


import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import com.chongdong.financialmanagementsystem.service.InventoryUsageService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Resource
    InventoryService inventoryService;
    @Resource
    InventoryUsageService inventoryUsageService;

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


    //出库操作:  库存id，使用数量
    @PostMapping("/Outbound")
    public ResponseMap InventoryOutbound(@RequestBody Outbound outbound){
        return inventoryService.Outbound(outbound);
    }

    //库存使用详情模糊查询
    @PostMapping("/inventoryUsageSearch")
    public ResponseMap searchInventoryUsage(@RequestBody SearchModel searchModel){
        return inventoryUsageService.searchInventoryUsage(searchModel);
    }

    //库存物品使用情况详情
    @PostMapping("/oneInventoryUsage")
    public ResponseMap oneInventoryUsageList(@RequestBody SearchModel searchModel){
        return inventoryUsageService.oneInventoryUsageList(searchModel);
    }

    //库存使用情况模糊查询
    @PostMapping("/searchOneInventoryUsage")
    public ResponseMap searchOneInventoryUsageList(@RequestBody SearchModel searchModel){
        return inventoryUsageService.searchOneInventoryUsageList(searchModel);
    }


    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"库存物品列表");
        EasyExcel.write(response.getOutputStream(), Labor.class).sheet("库存物品列表").doWrite(inventoryService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"库存物品列表");
        EasyExcel.write(response.getOutputStream(), Labor.class).sheet("库存物品列表").doWrite(inventoryService.searchList(searchModel));
    }



}
