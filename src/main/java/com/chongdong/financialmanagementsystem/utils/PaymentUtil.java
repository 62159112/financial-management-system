package com.chongdong.financialmanagementsystem.utils;

import com.chongdong.financialmanagementsystem.factory.EntityFactory;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.*;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentUtil {
    @Resource
    PaymentService paymentService;
    @Resource
    ExpensesService expensesService;
    @Resource
    LaborService laborService;
    @Resource
    OperateService operateService;
    @Resource
    ProcurementService procurementService;
    @Resource
    PurchaseService purchaseService;
    @Resource
    ReimbursementService reimbursementService;

    Expenses expenses = EntityFactory.createExpenses();
    Labor labor = EntityFactory.createLabor();
    Operate operate = EntityFactory.createOperate();
    Procurement procurement = EntityFactory.createProcurement();
    Purchase purchase = EntityFactory.createPurchase();
    Reimbursement reimbursement = EntityFactory.createReimbursement();

    @Transactional
    public Boolean updatePaymentWithOther(Payment payment){
        Payment oldPayment = paymentService.getById(payment.getId());
        switch (oldPayment.getType()){
            case "费用成本" -> {
                BeanUtils.copyProperties(expenses, payment);
                expenses.setId(null);
                expenses.setType(null);
                return expensesService.updateWithPayment(expenses) && paymentService.updateById(payment);
            }
            case "人工成本" -> {
                BeanUtils.copyProperties(labor, payment);
                labor.setId(null);
                labor.setType(null);
                return laborService.updateWithPayment(labor) && paymentService.updateById(payment);
            }
            case "运营成本" -> {
                BeanUtils.copyProperties(operate, payment);
                operate.setId(null);
                operate.setType(null);
                return operateService.updateWithPayment(operate) && paymentService.updateById(payment);
            }
            case "采购成本" -> {
                BeanUtils.copyProperties(procurement, payment);
                procurement.setId(null);
                procurement.setType(null);
                return procurementService.updateWithPayment(procurement) && paymentService.updateById(payment);
            }
            case "购置成本" -> {
                BeanUtils.copyProperties(purchase, payment);
                purchase.setId(null);
                purchase.setType(null);
                return purchaseService.updateWithPayment(purchase) && paymentService.updateById(payment);
            }
            case "报销成本" -> {
                BeanUtils.copyProperties(reimbursement, payment);
                reimbursement.setId(null);
                reimbursement.setType(null);
                return reimbursementService.updateWithPayment(reimbursement) && paymentService.updateById(payment);
            }
            case "其它" -> {
                return paymentService.updateById(payment);
            }
        }
        return false;
    }
    @Transactional
    public Boolean deletePaymentWithOther(Integer id){
        Payment payment = paymentService.getById(id);
        switch (payment.getType()){
            case "费用成本" -> {
                BeanUtils.copyProperties(payment, expenses);
                expenses.setId(null);
                return expensesService.deleteWithPayment(expenses) && paymentService.removeById(payment);
            }
            case "人工成本" -> {
                BeanUtils.copyProperties(payment, labor);
                labor.setId(null);
                return laborService.deleteWithPayment(labor) && paymentService.removeById(payment);
            }
            case "运营成本" -> {
                BeanUtils.copyProperties(payment, operate);
                operate.setId(null);
                return operateService.deleteWithPayment(operate) && paymentService.removeById(payment);
            }
            case "采购成本" -> {
                BeanUtils.copyProperties(payment, procurement);
                procurement.setId(null);
                return procurementService.deleteWithPayment(procurement) && paymentService.removeById(payment);
            }
            case "购置成本" -> {
                BeanUtils.copyProperties(payment, purchase);
                purchase.setId(null);
                return purchaseService.deleteWithPayment(purchase) && paymentService.removeById(payment);
            }
            case "报销成本" -> {
                BeanUtils.copyProperties(payment, reimbursement);
                reimbursement.setId(null);
                return reimbursementService.deleteWithPayment(reimbursement) && paymentService.removeById(payment);
            }
            case "其它" -> {
                return paymentService.removeById(payment);
            }
        }
        return false;
    }
}
