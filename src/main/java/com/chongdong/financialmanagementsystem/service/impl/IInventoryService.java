package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.mapper.InventoryUsageMapper;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import com.chongdong.financialmanagementsystem.mapper.InventoryMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
    InventoryMapper inventoryMapper;
    @Resource
    InventoryUsageMapper inventoryUsageMapper;
    @Resource
    PageUtil<Inventory> pageUtil;
    @Resource
    WrapperUtil<Inventory> wrapperUtil;
    @Resource
    ResponseMapUtil<Inventory> responseMapUtil;
    ResponseMap responseMap=new ResponseMap();

    @Override
    public ResponseMap addInventory(Inventory inventory) {
        inventory.setUpdateTime(new Date());
        inventory.setUsedQuantity(0);
        if (inventory.getName()!=null && inventory.getDirector()!=null && inventory.getTotal()>0 && inventory.getType()!=null){
            inventoryMapper.insert(inventory);
            responseMap.setFlag(true);
            responseMap.setData(inventory);
            responseMap.setMessage("添加成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(inventory);
            responseMap.setMessage("添加失败，请检查参数是否正确");
        }
        return responseMap;
    }

    @Override
    public ResponseMap updateInventory(Inventory inventory) {
        inventory.setUpdateTime(new Date());
        if (inventory.getName()!=null && inventory.getDirector()!=null && inventory.getTotal()>0 && inventory.getType()!=null){
            responseMap.setFlag(false);
            responseMap.setData(false);
            responseMap.setMessage("修改失败，请检查参数是否正确");
            return responseMap;
        }
        if (inventoryMapper.updateById(inventory)>0){
            responseMap.setFlag(true);
            responseMap.setData(inventory);
            responseMap.setMessage("修改成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(false);
            responseMap.setMessage("修改失败，请检查参数是否正确");
        }
        return responseMap;
    }

    @Override
    public ResponseMap deleteInventory(Integer id) {
        if (id<0){
            responseMap.setFlag(false);
            responseMap.setData(false);
            responseMap.setMessage("删除失败，请检查参数是否正确");
        } else if (inventoryMapper.deleteById(id)>0){
            responseMap.setFlag(true);
            responseMap.setData(true);
            responseMap.setMessage("删除成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(false);
            responseMap.setMessage("删除失败，请检查参数是否正确");
        }
        return responseMap;
    }

    @Override
    public ResponseMap getInventory(Integer id) {
        if (id!=null && id>0){
            Inventory inventory = inventoryMapper.selectById(id);
            responseMap.setFlag(true);
            responseMap.setData(inventory);
            responseMap.setMessage("查询成功");
        }else {
            responseMap.setFlag(false);
            responseMap.setData(null);
            responseMap.setMessage("查询失败");
        }
        return responseMap;
    }

    @Override
    public ResponseMap listInventory(Integer page, Integer size) {
        Page<Inventory> pageList = this.page(pageUtil.getModelPage(page, size), wrapperUtil.wrapperTimeDescOne());
        Map<String,Object> modelMap=pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }



    @Override
    public ResponseMap searchInventory(SearchModel searchModel) {
        Page<Inventory> searchList=this.page(pageUtil.getModelPage(searchModel.getPage(),searchModel.getSize()),
                wrapperUtil.wrapperNormal66(searchModel.getSearch(),searchModel.getStartTime(),searchModel.getEndTime()));
        Map<String,Object> modelMap=pageUtil.getModelMap(searchList);
        return responseMapUtil.getPageList(searchList,modelMap);
    }

    @Override
    public Boolean addOtherWithInventory(Inventory inventory) {
        Inventory oldInventory = this.getOne(wrapperUtil.wrapperName(inventory.getName()));
        inventory.setUpdateTime(new Date());
        if (oldInventory==null){
            inventory.setUsedQuantity(0);
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

    @Override
    public ResponseMap Outbound(Outbound outbound) {
        if (outbound.getId() > 0 && outbound.getQuantity() > 0){
            Inventory inventory = inventoryMapper.selectById(outbound.getId());
            if (inventory.getTotal()<outbound.getQuantity()){
                responseMap.setFlag(false);
                responseMap.setData(false);
                responseMap.setMessage("出库失败，没有这么多库存，请检查数量是否正确！！！");
            }else {
                inventory.setTotal(inventory.getTotal()-outbound.getQuantity());
                inventory.setUsedQuantity(inventory.getUsedQuantity()+outbound.getQuantity());
                InventoryUsage inventoryUsage=new InventoryUsage();
                inventoryUsage.setArticle(inventory.getName());
                inventoryUsage.setUser(outbound.getUser());
                inventoryUsage.setCreateTime(new Date());
                inventoryUsage.setQuantity(outbound.getQuantity());
                inventoryUsage.setRemark(outbound.getRemark());
                if (inventoryMapper.updateById(inventory)>0 && inventoryUsageMapper.insert(inventoryUsage)>0){
                    responseMap.setFlag(true);
                    responseMap.setData(true);
                    responseMap.setMessage("出库成功！！！");
                }else {
                    responseMap.setFlag(false);
                    responseMap.setData(false);
                    responseMap.setMessage("出库失败，请检查参数是否正确或稍后重试！！！");
                }
            }
        }
        return responseMap;
    }

}




