package com.chongdong.financialmanagementsystem.service;

import com.chongdong.financialmanagementsystem.model.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_sale(销售出账条目)】的数据库操作Service
* @createDate 2023-08-03 15:37:03
*/
public interface SaleService extends IService<Sale> {
    ResponseMap addSale(Sale sale);

    ResponseMap updateSale(Sale sale);

    ResponseMap deleteSale(Integer id);

    ResponseMap getSale(Integer id);

    ResponseMap listSale(Integer page,Integer size);

    ResponseMap searchSale(SearchModel searchModel);

    Boolean updateWithIncome(Sale sale);

    Boolean deleteWithIncome(Sale sale);

    ResponseMap countSale();

    List<Sale> exportList(Integer page, Integer size);

    List<Sale> searchList(SearchModel searchModel);
}
