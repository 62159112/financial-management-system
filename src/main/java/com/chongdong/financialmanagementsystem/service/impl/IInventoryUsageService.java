package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.mapper.InventoryMapper;
import com.chongdong.financialmanagementsystem.model.Inventory;
import com.chongdong.financialmanagementsystem.model.InventoryUsage;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.InventoryUsageService;
import com.chongdong.financialmanagementsystem.mapper.InventoryUsageMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author cd
* @description 针对表【tcd_inventory_usage(库存物品使用详情)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:45
*/
@Service
public class IInventoryUsageService extends ServiceImpl<InventoryUsageMapper, InventoryUsage>
    implements InventoryUsageService{
    @Resource
    InventoryMapper inventoryMapper;
    @Resource
    InventoryUsageMapper inventoryUsageMapper;
    @Resource
    PageUtil<InventoryUsage> pageUtil;
    @Resource
    WrapperUtil<InventoryUsage> wrapperUtil;
    @Resource
    ResponseMapUtil<InventoryUsage> responseMapUtil;
    ResponseMap responseMap=new ResponseMap();

    @Override
    public ResponseMap searchInventoryUsage(SearchModel searchModel) {
        Page<InventoryUsage> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperNormal22(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap oneInventoryUsageList(SearchModel searchModel) {
        if (searchModel.getSearch()==null || searchModel.getSearch().equals("")){
            responseMap.setMessage("参数不能为空！！！");
            responseMap.setData(false);
            responseMap.setFlag(false);
            return responseMap;
        }
        Page<InventoryUsage> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperNormal33(searchModel.getSearch(), searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }
}




