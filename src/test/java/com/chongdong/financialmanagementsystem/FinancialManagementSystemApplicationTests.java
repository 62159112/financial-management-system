package com.chongdong.financialmanagementsystem;

import com.chongdong.financialmanagementsystem.model.Expenses;
import com.chongdong.financialmanagementsystem.service.ExpensesService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class FinancialManagementSystemApplicationTests {
    @Resource
    ExpensesService expensesService;
    @Test
    void contextLoads() {
        Expenses expenses = new Expenses();
        expenses.setAmount(new BigDecimal("12.66"));
        expenses.setDirector("爱不疚");
        expenses.setName("大订单");
        expenses.setType("哦哦哦");
        expenses.setAddress("翻斗花园");

    }

}
