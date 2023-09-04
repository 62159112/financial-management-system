package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.InventoryService;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.service.PurchaseService;
import com.chongdong.financialmanagementsystem.mapper.PurchaseMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cd
 * @description 针对表【tcd_purchase(购置条目)】的数据库操作Service实现
 * @createDate 2023-08-03 15:36:58
 */
@Service
public class IPurchaseService extends ServiceImpl<PurchaseMapper, Purchase>
        implements PurchaseService{
    @Resource
    PageUtil<Purchase> pageUtil;
    @Resource
    WrapperUtil<Purchase> wrapperUtil;
    @Resource
    ResponseMapUtil<Purchase> responseMapUtil;
    @Resource
    PaymentService paymentService;
    @Resource
    InventoryService inventoryService;

    Payment payment = EntityFactory.createPayment();

    Inventory inventory = EntityFactory.createInventory();
    @Override
    @Transactional
    public ResponseMap addPurchase(Purchase purchase, BindingResult bindingResult) {
        ResponseMap bindingMap = responseMapUtil.getBindingResult(bindingResult);
        if(bindingMap.getFlag()){
            purchase.setCreateTime(new Date());
            BeanUtils.copyProperties(purchase,payment);
            payment.setType("购置成本");
            BeanUtils.copyProperties(purchase,inventory);
            inventory.setTotal(purchase.getQuantity());
            return responseMapUtil.addEntity(this.save(purchase) && paymentService.addOtherWithPayment(payment)
                    && inventoryService.addOtherWithInventory(inventory));
        }else {
            return bindingMap;
        }

    }

    @Override
    @Transactional
    public ResponseMap updatePurchase(Purchase purchase, BindingResult bindingResult) {
        ResponseMap bindingMap = responseMapUtil.getBindingResult(bindingResult);
        if(bindingMap.getFlag()){
            Purchase oldPurchase = this.getById(purchase.getId());
            BeanUtils.copyProperties(purchase,payment);
            payment.setId(null);
            payment.setType("购置成本");
            BeanUtils.copyProperties(purchase,inventory);
            inventory.setTotal(purchase.getQuantity() - oldPurchase.getQuantity());
            return responseMapUtil.updateEntity(this.updateById(purchase) && paymentService.updateOtherWithPayment(payment)
                    && inventoryService.UpdateOtherWithInventory(inventory));
        }else {
            return bindingMap;
        }
    }

    @Override
    @Transactional
    public ResponseMap deletePurchase(Integer id) {
        Purchase purchase = this.getById(id);
        BeanUtils.copyProperties(purchase,payment);
        payment.setId(null);
        payment.setType(null);
        BeanUtils.copyProperties(purchase,inventory);
        inventory.setTotal(purchase.getQuantity());
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPayment(payment)
                && inventoryService.deleteOtherWithInventory(inventory));
    }

    @Override
    public ResponseMap getPurchase(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listPurchase(Integer page, Integer size) {
        Page<Purchase> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc());
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchPurchase(SearchModel searchModel) {
        Page<Purchase> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(),searchModel.getSize()),wrapperUtil.wrapperNormal(searchModel.getSearch(),searchModel.getStartTime(),searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public Boolean updateWithPayment(Purchase purchase) {
        Purchase oldPurchase = this.getOne(wrapperUtil.wrapperTime(purchase.getCreateTime()));
        purchase.setId(oldPurchase.getId());
        return this.updateById(purchase);
    }

    @Override
    public Boolean deleteWithPayment(Purchase purchase) {
        Purchase oldPurchase = this.getOne(wrapperUtil.wrapperTime(purchase.getCreateTime()));
        return this.removeById(oldPurchase.getId());
    }

    @Override
    public ResponseMap countPurchase() {
        List<Purchase> purchaseList = this.list();
        BigDecimal count = BigDecimal.valueOf(0);
        for (Purchase purchase : purchaseList) {
            count = count.add(purchase.getAmount());
        }
        return responseMapUtil.countList(count);
    }

    @Override
    public List<Purchase> exportList(Integer page, Integer size) {
        return this.page(pageUtil.getModelPage(page, size)).getRecords();
    }

    @Override
    public List<Purchase> searchList(SearchModel searchModel) {
        Page<Purchase> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(),searchModel.getSize()),wrapperUtil.wrapperNormal(searchModel.getSearch(),searchModel.getStartTime(),searchModel.getEndTime()));
        return pageList.getRecords();
    }
}




