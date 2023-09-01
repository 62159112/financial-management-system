package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.service.SaleService;
import com.chongdong.financialmanagementsystem.mapper.SaleMapper;
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
* @description 针对表【tcd_sale(销售出账条目)】的数据库操作Service实现
* @createDate 2023-08-03 15:37:03
*/
@Service
public class ISaleService extends ServiceImpl<SaleMapper, Sale>
    implements SaleService{
    @Resource
    PageUtil<Sale> pageUtil;
    @Resource
    WrapperUtil<Sale> wrapperUtil;
    @Resource
    ResponseMapUtil<Sale> responseMapUtil;
    @Resource
    IncomeService incomeService;

    Income income = EntityFactory.createIncome();

    @Override
    @Transactional
    public ResponseMap addSale(Sale sale) {
        sale.setCreateTime(new Date());
        BeanUtils.copyProperties(sale,income);
        income.setType("销售出账");
        return responseMapUtil.addEntity(this.save(sale) && incomeService.addOtherWithIncome(income));
    }

    @Override
    @Transactional
    public ResponseMap updateSale(Sale sale) {
        BeanUtils.copyProperties(sale,income);
        income.setId(null);
        income.setType(null);
        return responseMapUtil.updateEntity(this.updateById(sale) && incomeService.updateOtherWithIncome(income));
    }

    @Override
    @Transactional
    public ResponseMap deleteSale(Integer id) {
        Sale sale = this.getById(id);
        BeanUtils.copyProperties(sale,income);
        income.setId(null);
        income.setType(null);
        return responseMapUtil.deleteEntity(this.removeById(id) && incomeService.deleteOtherWithIncome(income));
    }

    @Override
    public ResponseMap getSale(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listSale(Integer page, Integer size) {
        Page<Sale> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc());
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchSale(SearchModel searchModel) {
        Page<Sale> searchList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperLike(searchModel.getSearch()));
        Page<Sale> pageList = this.page(searchList, wrapperUtil.wrapperTimeSlot(searchModel.getStartTime(), searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public Boolean updateWithIncome(Sale sale) {
        Sale oldSale = this.getOne(wrapperUtil.wrapperTime(sale.getCreateTime()));
        sale.setId(oldSale.getId());
        return this.updateById(sale);
    }

    @Override
    public Boolean deleteWithIncome(Sale sale) {
        Sale oldSale = this.getOne(wrapperUtil.wrapperTime(sale.getCreateTime()));
        return this.removeById(oldSale.getId());
    }

    @Override
    public ResponseMap countSale() {
        List<Sale> saleList = this.list();
        BigDecimal count = BigDecimal.valueOf(0);
        for (Sale sale : saleList) {
            count = count.add(sale.getAmount());
        }
        return responseMapUtil.countList(count);
    }
}




