package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import com.chongdong.financialmanagementsystem.utils.PaymentUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Resource
    PaymentUtil paymentUtil;

    @GetMapping("/{id}")
    public ResponseMap getPayment(@PathVariable Integer id){
        return paymentService.getPayment(id);
    }
    
    @GetMapping("/list/{page}/{size}")
    public ResponseMap listPayment(@PathVariable Integer page, @PathVariable Integer size){
        return paymentService.listPayment(page,size);
    }
    @PostMapping
    public ResponseMap addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }
    @PostMapping("/search")
    public ResponseMap searchPayment(@RequestBody SearchModel searchModel){
        return paymentService.searchPayment(searchModel);
    }

    @PutMapping
    public Boolean updatePayment(@RequestBody Payment payment){
        return paymentUtil.updatePaymentWithOther(payment);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePayment(@PathVariable Integer id){
        return paymentUtil.deletePaymentWithOther(id);
    }

    @GetMapping("/count")
    public ResponseMap countPayment(){
        return paymentService.countPayment();
    }

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"支出列表");
        EasyExcel.write(response.getOutputStream(),Payment.class).sheet("支出列表").doWrite(paymentService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"支出列表");
        EasyExcel.write(response.getOutputStream(),Payment.class).sheet("支出列表").doWrite(paymentService.searchList(searchModel));
    }
}
