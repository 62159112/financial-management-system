package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.Sale;
import com.chongdong.financialmanagementsystem.model.Type;
import com.chongdong.financialmanagementsystem.service.TypeService;
import com.chongdong.financialmanagementsystem.mapper.TypeMapper;
import com.chongdong.financialmanagementsystem.utils.PageUtil;
import com.chongdong.financialmanagementsystem.utils.ResponseMapUtil;
import com.chongdong.financialmanagementsystem.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author cd
* @description 针对表【tcd_type(类型管理)】的数据库操作Service实现
* @createDate 2023-08-03 15:37:08
*/
@Service
public class ITypeService extends ServiceImpl<TypeMapper, Type>
    implements TypeService{
    @Resource
    PageUtil<Type> pageUtil;
    @Resource
    WrapperUtil<Type> wrapperUtil;
    @Resource
    ResponseMapUtil<Type> responseMapUtil;

    @Override
    public ResponseMap addType(Type type) {
        return responseMapUtil.addEntity(this.save(type));
    }

    @Override
    public ResponseMap updateType(Type type) {
        return responseMapUtil.updateEntity(this.updateById(type));
    }

    @Override
    public ResponseMap deleteType(Integer id) {
        return responseMapUtil.updateEntity(this.removeById(id));
    }


    @Override
    public ResponseMap listType(Integer belong, Integer page, Integer size) {
        Page<Type> pageList = this.page(pageUtil.getModelPage(page, size),
                wrapperUtil.wrapperType(belong));
        Map<String, Object> modelMap = pageUtil.getModelMap(pageList);
        return responseMapUtil.getPageList(pageList,modelMap);
    }

    @Override
    public ResponseMap listTypeWithOutPage(Integer belong) {
        List<Type> typeList = this.list(wrapperUtil.wrapperType(belong));
        return responseMapUtil.getList(typeList);
    }
}




