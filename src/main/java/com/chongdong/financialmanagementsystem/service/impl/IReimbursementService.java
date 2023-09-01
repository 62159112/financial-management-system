package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.service.ReimbursementService;
import com.chongdong.financialmanagementsystem.mapper.ReimbursementMapper;
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
* @description 针对表【tcd_reimbursement(报销条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:37:01
*/
@Service
public class IReimbursementService extends ServiceImpl<ReimbursementMapper, Reimbursement>
    implements ReimbursementService{
    @Resource
    PageUtil<Reimbursement> pageUtil;
    @Resource
    WrapperUtil<Reimbursement> wrapperUtil;
    @Resource
    ResponseMapUtil<Reimbursement> responseMapUtil;
    @Resource
    PaymentService paymentService;

    Payment payment = EntityFactory.createPayment();

    @Override
    @Transactional
    public ResponseMap addReimbursement(Reimbursement reimbursement) {
        reimbursement.setCreateTime(new Date());
        BeanUtils.copyProperties(reimbursement,payment);
        payment.setType("报销成本");
        return responseMapUtil.addEntity(this.save(reimbursement) && paymentService.addOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap updateReimbursement(Reimbursement reimbursement) {
        BeanUtils.copyProperties(reimbursement,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.updateEntity(this.updateById(reimbursement) && paymentService.updateOtherWithPayment(payment));
    }

    @Override
    @Transactional
    public ResponseMap deleteReimbursement(Integer id) {
        Reimbursement reimbursement = this.getById(id);
        BeanUtils.copyProperties(reimbursement,payment);
        payment.setId(null);
        payment.setType(null);
        return responseMapUtil.deleteEntity(this.removeById(id) && paymentService.deleteOtherWithPayment(payment));
    }

    @Override
    public ResponseMap getReimbursement(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listReimbursement(Integer page, Integer size) {
        Page<Reimbursement> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc());
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchReimbursement(SearchModel searchModel) {
        Page<Reimbursement> searchList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperLike(searchModel.getSearch()));
        Page<Reimbursement> pageList = this.page(searchList, wrapperUtil.wrapperTimeSlot(searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public Boolean updateWithPayment(Reimbursement reimbursement) {
        Reimbursement oldReimbursement = this.getOne(wrapperUtil.wrapperTime(reimbursement.getCreateTime()));
        reimbursement.setId(oldReimbursement.getId());
        return this.updateById(reimbursement);
    }

    @Override
    public Boolean deleteWithPayment(Reimbursement reimbursement) {
        Reimbursement oldReimbursement = this.getOne(wrapperUtil.wrapperTime(reimbursement.getCreateTime()));
        return this.removeById(oldReimbursement.getId());
    }

    @Override
    public ResponseMap countReimbursement() {
        List<Reimbursement> reimbursementList = this.list();
        BigDecimal count = BigDecimal.valueOf(0);
        for (Reimbursement reimbursement : reimbursementList) {
            count = count.add(reimbursement.getAmount());
        }
        return responseMapUtil.countList(count);
    }
}




