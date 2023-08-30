package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Inventory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;

/**
* @author cd
* @description 针对表【tcd_inventory(库存条目)】的数据库操作Service
* @createDate 2023-08-03 15:36:33
*/
public interface InventoryService extends IService<Inventory> {

    ResponseMap addInventory(Inventory inventory);

    ResponseMap updateInventory(Inventory inventory);

    ResponseMap deleteInventory(Integer id);

    ResponseMap getInventory(Integer id);

    ResponseMap listInventory(Integer page, Integer size);

    ResponseMap searchInventory(SearchModel searchModel);

    Boolean addOtherWithInventory(Inventory inventory);

    Boolean UpdateOtherWithInventory(Inventory inventory);

    Boolean deleteOtherWithInventory(Inventory inventory);
}
