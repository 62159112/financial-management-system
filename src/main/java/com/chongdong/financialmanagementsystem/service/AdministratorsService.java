package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.Administrators;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cd
* @description 针对表【tcd_administrators(管理员)】的数据库操作Service
* @createDate 2023-08-03 15:37:11
*/
public interface AdministratorsService extends IService<Administrators> {

    Administrators queryAdmin(Administrators administrators);

}
