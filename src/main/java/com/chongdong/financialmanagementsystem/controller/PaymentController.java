package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Payment;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.PaymentService;
import com.chongdong.financialmanagementsystem.utils.PaymentUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
}
