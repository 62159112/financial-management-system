package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Inventory;
import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import com.chongdong.financialmanagementsystem.mapper.InventoryMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author cd
* @description 针对表【tcd_inventory(库存条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:33
*/
@Service
public class IInventoryService extends ServiceImpl<InventoryMapper, Inventory>
    implements InventoryService{
    @Resource
    PageUtil<Inventory> pageUtil;
    @Resource
    WrapperUtil<Inventory> wrapperUtil;
    @Resource
    ResponseMapUtil<Inventory> responseMapUtil;

    @Override
    public ResponseMap addInventory(Inventory inventory) {
        return null;
    }

    @Override
    public ResponseMap updateInventory(Inventory inventory) {
        return null;
    }

    @Override
    public ResponseMap deleteInventory(Integer id) {
        return null;
    }

    @Override
    public ResponseMap getInventory(Integer id) {
        return null;
    }

    @Override
    public ResponseMap listInventory(Integer page, Integer size) {
        Page<Inventory> pageList = pageUtil.getPageList(this.getBaseMapper(),pageUtil.getModelPage(page, size));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchInventory(SearchModel searchModel) {
        Page<Inventory> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
        wrapperUtil.wrapperNormal(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public Boolean addOtherWithInventory(Inventory inventory) {
        Inventory oldInventory = this.getOne(wrapperUtil.wrapperName(inventory.getName()));
        if (oldInventory==null){
            return this.save(inventory);
        }else {
            oldInventory.setTotal(oldInventory.getTotal()+ inventory.getTotal());
            return this.updateById(oldInventory);
        }
    }

    @Override
    public Boolean UpdateOtherWithInventory(Inventory inventory) {
        Inventory oldInventory = this.getOne(wrapperUtil.wrapperName(inventory.getName()));
        oldInventory.setTotal(oldInventory.getTotal()+ inventory.getTotal());
        return this.updateById(oldInventory);
    }

    @Override
    public Boolean deleteOtherWithInventory(Inventory inventory) {
        Inventory oldInventory = this.getOne(wrapperUtil.wrapperName(inventory.getName()));
        oldInventory.setTotal(oldInventory.getTotal() - inventory.getTotal());
        return this.updateById(oldInventory);
    }
}




