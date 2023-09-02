package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.LaborService;
import com.chongdong.financialmanagementsystem.mapper.LaborMapper;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cd
 * @description 针对表【tcd_labor(人工成本条目)】的数据库操作Service实现
 * @createDate 2023-08-03 15:36:49
 */
@Service
public class ILaborService extends ServiceImpl<LaborMapper, Labor>
        implements LaborService {
    @Resource
    PageUtil<Labor> pageUtil;
    @Resource
    WrapperUtil<Labor> wrapperUtil;
    @Resource
    ResponseMapUtil<Labor> responseMapUtil;
    @Resource
    PaymentService paymentService;

    Payment payment = EntityFactory.createPayment();

    @Override
    @Transactional
    public ResponseMap addLabor(Labor labor) {
        labor.setCreateTime(new Date());
        BeanUtils.copyProperties(labor,payment);
        payment.setType("人工成本");
        return responseMapUtil.addEntity(this.save(labor) && paymentService.addOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap updateLabor(Labor labor) {
        BeanUtils.copyProperties(labor,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.updateEntity(this.updateById(labor) && paymentService.updateOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap deleteLabor(Integer id) {
        Labor labor = this.getById(id);
        BeanUtils.copyProperties(labor,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPayment(payment));
    }

    @Override
    public ResponseMap getLabor(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listLabor(Integer page, Integer size) {
        Page<Labor> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc());
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchLabor(SearchModel searchModel) {
        Page<Labor> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(),searchModel.getSize()),
                wrapperUtil.wrapperNormal(searchModel.getSearch(),searchModel.getStartTime(),searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public Boolean updateWithPayment(Labor labor) {
        Labor oldLabor = this.getOne(wrapperUtil.wrapperTime(labor.getCreateTime()));
        labor.setId(oldLabor.getId());
        return this.updateById(labor);
    }

    @Override
    public Boolean deleteWithPayment(Labor labor) {
        Labor oldLabor = this.getOne(wrapperUtil.wrapperTime(labor.getCreateTime()));
        return this.removeById(oldLabor.getId());
    }

    @Override
    public ResponseMap countLabor() {
        List<Labor> laborList = this.list();
        BigDecimal count = BigDecimal.valueOf(0);
        for (Labor labor : laborList) {
            count = count.add(labor.getAmount());
        }
        return responseMapUtil.countList(count);
    }

    @Override
    public List<Labor> exportList(Integer page, Integer size) {
        return this.page(pageUtil.getModelPage(page, size)).getRecords();
    }

    @Override
    public List<Labor> searchList(SearchModel searchModel) {
        Page<Labor> searchList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperLike(searchModel.getSearch()));
        Page<Labor> pageList = this.page(searchList, wrapperUtil.wrapperTimeSlot(searchModel.getStartTime(), searchModel.getEndTime()));
        return pageList.getRecords();
    }
}




