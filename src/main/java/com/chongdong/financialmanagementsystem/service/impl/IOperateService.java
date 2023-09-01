package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.OperateService;
import com.chongdong.financialmanagementsystem.mapper.OperateMapper;
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
* @description 针对表【tcd_operate(运营成本条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:36:52
*/
@Service
public class  IOperateService extends ServiceImpl<OperateMapper, Operate>
    implements OperateService{
    @Resource
    PageUtil<Operate> pageUtil;
    @Resource
    WrapperUtil<Operate> wrapperUtil;
    @Resource
    ResponseMapUtil<Operate> responseMapUtil;
    @Resource
    PaymentService paymentService;

    Payment payment = EntityFactory.createPayment();

    @Override
    @Transactional
    public ResponseMap addOperate(Operate operate) {
        operate.setCreateTime(new Date());
        BeanUtils.copyProperties(operate,payment);
        payment.setType("运营成本");
        return responseMapUtil.addEntity(this.save(operate) && paymentService.addOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap updateOperate(Operate operate) {
        BeanUtils.copyProperties(operate,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.updateEntity(this.updateById(operate) && paymentService.updateOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap deleteOperate(Integer id) {
        Operate operate = this.getById(id);
        BeanUtils.copyProperties(operate,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPayment(payment));
    }

    @Override
    public ResponseMap getOperate(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listOperate(Integer page, Integer size) {
        Page<Operate> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc());
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchOperate(SearchModel searchModel) {
        Page<Operate> searchList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperLike(searchModel.getSearch()));
        Page<Operate> pageList = this.page(searchList, wrapperUtil.wrapperTimeSlot(searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public Boolean updateWithPayment(Operate operate) {
        Operate oldOperate = this.getOne(wrapperUtil.wrapperTime(operate.getCreateTime()));
        operate.setId(oldOperate.getId());
        return this.updateById(operate);
    }

    @Override
    public Boolean deleteWithPayment(Operate operate) {
        Operate oldOperate = this.getOne(wrapperUtil.wrapperTime(operate.getCreateTime()));
        return this.removeById(oldOperate.getId());
    }

    @Override
    public ResponseMap countOperate() {
        List<Operate> operateList = this.list();
        BigDecimal count = BigDecimal.valueOf(0);
        for (Operate operate : operateList) {
            count = count.add(operate.getAmount());
        }
        return responseMapUtil.countList(count);
    }
}




