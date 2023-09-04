package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_operate(运营成本条目)】的数据库操作Service
* @createDate 2023-08-03 15:36:52
*/
public interface OperateService extends IService<Operate> {
    ResponseMap addOperate(Operate operate, BindingResult bindingResult);

    ResponseMap updateOperate(Operate operate, BindingResult bindingResult);

    ResponseMap deleteOperate(Integer id);

    ResponseMap getOperate(Integer id);

    ResponseMap listOperate(Integer page,Integer size);

    ResponseMap searchOperate(SearchModel searchModel);

    Boolean updateWithPayment(Operate operate);

    Boolean deleteWithPayment(Operate operate);

    ResponseMap countOperate();

    List<Operate> exportList(Integer page, Integer size);

    List<Operate> searchList(SearchModel searchModel);
}
