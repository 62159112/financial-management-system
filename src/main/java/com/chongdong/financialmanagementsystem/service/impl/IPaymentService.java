package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Operate;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.mapper.PaymentMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cd
 * @description 针对表【tcd_payment(支出条目)】的数据库操作Service实现
 * @createDate 2023-08-04 15:13:59
 */
@Service
public class IPaymentService extends ServiceImpl<PaymentMapper, Payment>
        implements PaymentService{
    @Resource
    ResponseMapUtil<Payment> responseMapUtil;
    @Resource
    WrapperUtil<Payment> wrapperUtil;
    @Resource
    PageUtil<Payment> pageUtil;



    @Override
    public Boolean addOtherWithPayment(Payment payment) {
        return this.save(payment);
    }

    @Override
    public Boolean updateOtherWithPayment(Payment payment) {
        Payment oldPayment = this.getOne(wrapperUtil.wrapperGetOne(payment.getName(), payment.getCreateTime()));
        oldPayment.setAmount(payment.getAmount());
        return this.updateById(oldPayment);
    }

    @Override
    public Boolean deleteOtherWithPayment(Payment payment) {
        return this.remove(wrapperUtil.wrapperGetOne(payment.getName(),payment.getCreateTime()));
    }
    //TODO 修改删除根据类型找到相应service（若为其它则不管）  使用事务同时删除
    @Override
    public ResponseMap addPayment(Payment payment) {
        payment.setCreateTime(new Date());
        return responseMapUtil.addEntity(this.save(payment));
    }

    @Override
    @Transactional
    public ResponseMap updatePayment(Payment payment) {
        return responseMapUtil.updateEntity(this.updateById(payment));
    }

    @Override
    @Transactional
    public ResponseMap deletePayment(Integer id) {
        Payment payment = this.getById(id);
        return responseMapUtil.deleteEntity(this.removeById(id));
    }

    @Override
    public ResponseMap getPayment(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listPayment(Integer page, Integer size) {
        Page<Payment> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc());
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchPayment(SearchModel searchModel) {
        Page<Payment> searchList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperLike(searchModel.getSearch()));
        Page<Payment> pageList = this.page(searchList, wrapperUtil.wrapperTimeSlot(searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap countPayment() {
        List<Payment> paymentList = this.list();
        BigDecimal count = BigDecimal.valueOf(0);
        for (Payment payment : paymentList) {
            count = count.add(payment.getAmount());
        }
        return responseMapUtil.countList(count);
    }

    @Override
    public List<Payment> exportList(Integer page,Integer size) {
        return this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc()).getRecords();
    }
}




