package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.IncomeService;
import com.chongdong.financialmanagementsystem.mapper.IncomeMapper;
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
 * @description 针对表【tcd_income(收入条目)】的数据库操作Service实现
 * @createDate 2023-08-03 14:41:11
 */
@Service
public class IIncomeService extends ServiceImpl<IncomeMapper, Income>
        implements IncomeService{
    @Resource
    ResponseMapUtil<Income> responseMapUtil;
    @Resource
    WrapperUtil<Income> wrapperUtil;
    @Resource
    PageUtil<Income> pageUtil;


    @Override
    public Boolean addOtherWithIncome(Income income) {
        return this.save(income);
    }

    @Override
    public Boolean updateOtherWithIncome(Income income) {
        return this.update(wrapperUtil.wrapperGetOne(income.getName(),income.getCreateTime()));
    }

    @Override
    public Boolean deleteOtherWithIncome(Income income) {
        return this.remove(wrapperUtil.wrapperGetOne(income.getName(),income.getCreateTime()));
    }
    //TODO 修改删除根据类型找到相应service（若为其它则不管）  使用事务同时删除
    @Override
    public ResponseMap addIncome(Income income) {
        income.setCreateTime(new Date());
        return responseMapUtil.addEntity(this.save(income));
    }

    @Override
    @Transactional
    public ResponseMap updateIncome(Income income) {
        return responseMapUtil.updateEntity(this.updateById(income));
    }

    @Override
    @Transactional
    public ResponseMap deleteIncome(Integer id) {
        return responseMapUtil.deleteEntity(this.removeById(id));
    }

    @Override
    public ResponseMap getIncome(Integer id) {
        return responseMapUtil.getEntity(this.getById(id));
    }

    @Override
    public ResponseMap listIncome(Integer page, Integer size) {
        Page<Income> pageList = this.page(pageUtil.getModelPage(page, size),wrapperUtil.wrapperTimeDesc());
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap searchIncome(SearchModel searchModel) {
        Page<Income> pageList = this.page(pageUtil.getModelPage(searchModel.getPage(),searchModel.getSize()),wrapperUtil.wrapperNormal(searchModel.getSearch(),searchModel.getStartTime(),searchModel.getEndTime()));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap countIncome() {
        List<Income> incomeList = this.list();
        BigDecimal count = BigDecimal.valueOf(0);
        for (Income income : incomeList) {
            count = count.add(income.getAmount());
        }
        return responseMapUtil.countList(count);
    }

    @Override
    public List<Income> exportList(Integer page, Integer size) {
        return this.page(pageUtil.getModelPage(page, size)).getRecords();
    }

    @Override
    public List<Income> searchList(SearchModel searchModel) {
        Page<Income> searchList = this.page(pageUtil.getModelPage(searchModel.getPage(), searchModel.getSize()),
                wrapperUtil.wrapperLike(searchModel.getSearch()));
        Page<Income> pageList = this.page(searchList, wrapperUtil.wrapperTimeSlot(searchModel.getStartTime(), searchModel.getEndTime()));
        return pageList.getRecords();
    }
}




