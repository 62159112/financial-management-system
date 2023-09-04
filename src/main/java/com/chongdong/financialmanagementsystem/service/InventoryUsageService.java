package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Inventory;
import com.chongdong.financialmanagementsystem.model.InventoryUsage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_inventory_usage(库存物品使用详情)】的数据库操作Service
* @createDate 2023-08-03 15:36:45
*/
public interface InventoryUsageService extends IService<InventoryUsage> {

    ResponseMap searchInventoryUsage(SearchModel searchModel);

    ResponseMap oneInventoryUsageList(SearchModel searchModel);

    ResponseMap searchOneInventoryUsageList(SearchModel searchModel);

    List<InventoryUsage> exportList(Integer page, Integer size);

    List<InventoryUsage> searchList(SearchModel searchModel);


}
