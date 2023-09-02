package com.chongdong.financialmanagementsystem.controller;


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

//    @GetMapping("/export")
//    public void exportExcel(HttpServletResponse response) throws IOException {
//        ExcelUtil.setExcelHeader(response,"支出列表");
//        String fileName = URLEncoder.encode("支出列表", "UTF-8").replaceAll("\\+", "%20");
//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-disposition", "attachment;filename" + fileName + ".xlsx");
//        ExcelWriter writer = EasyExcel.write(response.getOutputStream()).build();
//        WriteSheet sheet = EasyExcel.writerSheet(0, "sheet").head(Payment.class).build();
//        List<Payment> paymentList = paymentService.exportList(1, 10);
//        writer.write(paymentList,sheet);
//        writer.finish();
//        EasyExcel.write(outputStream).head(Payment.class).excelType(ExcelTypeEnum.XLSX).sheet("用户列表").doWrite(paymentService.exportList(1, 10));
//    }

    /*@GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName=URLEncoder.encode("测试","UTF-8").replaceAll("\\+","%20");
        response.setHeader("Content-disposition","attachment;filename*=utf-8''"+fileName+".xlsx");
        EasyExcel.write(response.getOutputStream(),Payment.class).sheet("模板").doWrite(paymentService.exportList(1, 10));
    }*/
}
