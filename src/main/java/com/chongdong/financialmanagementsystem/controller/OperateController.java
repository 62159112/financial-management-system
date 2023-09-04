package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.*;
import com.chongdong.financialmanagementsystem.service.OperateService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/operate")
public class OperateController {
    @Resource
    OperateService operateService;

    @GetMapping("/{id}")
    public ResponseMap getOperate(@PathVariable Integer id){
        return operateService.getOperate(id);
    }

    @PostMapping
    public ResponseMap addOperate(@Validated({Operate.AddGroup.class})@RequestBody Operate operate, BindingResult bindingResult){
        return operateService.addOperate(operate,bindingResult);
    }

    @PutMapping
    public ResponseMap updateOperate(@Validated({Operate.UpdateGroup.class})@RequestBody Operate operate, BindingResult bindingResult){
        return operateService.updateOperate(operate,bindingResult);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deleteOperate(@PathVariable Integer id){
        return operateService.deleteOperate(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listOperate(@PathVariable  Integer page,@PathVariable Integer size){
        return operateService.listOperate(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchOperate(@RequestBody SearchModel searchModel){
        return operateService.searchOperate(searchModel);
    }

    @GetMapping("/count")
    public ResponseMap countOperate(){
        return operateService.countOperate();
    }

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"运营成本列表");
        EasyExcel.write(response.getOutputStream(), Operate.class).sheet("运营成本列表").doWrite(operateService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"运营成本列表");
        EasyExcel.write(response.getOutputStream(), Operate.class).sheet("运营成本列表").doWrite(operateService.searchList(searchModel));
    }
}
