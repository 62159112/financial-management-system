package com.chongdong.financialmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.financialmanagementsystem.model.Administrators;
import com.chongdong.financialmanagementsystem.service.AdministratorsService;
import com.chongdong.financialmanagementsystem.mapper.AdministratorsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_administrators(管理员)】的数据库操作Service实现
* @createDate 2023-08-03 15:37:11
*/
@Service
public class IAdministratorsService extends ServiceImpl<AdministratorsMapper, Administrators>
    implements AdministratorsService{
    @Resource
    AdministratorsMapper administratorsMapper;


    @Override
    public Administrators queryAdmin(Administrators administrators) {
        return administratorsMapper.selectOne(new QueryWrapper<Administrators>(administrators));
    }
}




