package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.financialmanagementsystem.model.Procurement;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_procurement(采购条目)】的数据库操作Service
* @createDate 2023-08-05 09:39:20
*/
public interface ProcurementService extends IService<Procurement> {
    ResponseMap addProcurement(Procurement procurement, BindingResult bindingResult);

    ResponseMap updateProcurement(Procurement procurement, BindingResult bindingResult);

    ResponseMap deleteProcurement(Integer id);

    ResponseMap getProcurement(Integer id);

    ResponseMap listProcurement(Integer page,Integer size);

    ResponseMap searchProcurement(SearchModel searchModel);

    Boolean updateWithPayment(Procurement procurement);

    Boolean deleteWithPayment(Procurement procurement);

    ResponseMap countProcurement();

    List<Procurement> exportList(Integer page, Integer size);

    List<Procurement> searchList(SearchModel searchModel);
}
