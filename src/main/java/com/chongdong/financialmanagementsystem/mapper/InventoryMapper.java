package com.chongdong.financialmanagementsystem.mapper;

import com.chongdong.financialmanagementsystem.model.Inventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_inventory(库存条目)】的数据库操作Mapper
* @createDate 2023-08-03 15:36:33
* @Entity com.chongdong.financialmanagementsystem.model.Inventory
*/
public interface InventoryMapper extends BaseMapper<Inventory> {

    List<Inventory> AllInventoryLimit(int offset,int limit);

}




