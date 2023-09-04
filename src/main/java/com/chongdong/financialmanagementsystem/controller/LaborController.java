package com.chongdong.financialmanagementsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.Operate;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.LaborService;
import com.chongdong.financialmanagementsystem.utils.ExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/labor")
public class LaborController {
    @Resource
    LaborService laborService;

    @GetMapping("/{id}")
    public ResponseMap getLabor(@PathVariable Integer id){
        return laborService.getLabor(id);
    }

    @PostMapping
    public ResponseMap addLabor(@Validated({Labor.AddGroup.class})@RequestBody Labor labor, BindingResult bindingResult){
        return laborService.addLabor(labor,bindingResult);
    }

    @PutMapping
    public ResponseMap updateLabor(@Validated({Labor.UpdateGroup.class})@RequestBody Labor labor, BindingResult bindingResult){
        return laborService.updateLabor(labor,bindingResult);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deleteLabor(@PathVariable Integer id){
        return laborService.deleteLabor(id);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseMap listLabor(@PathVariable  Integer page,@PathVariable Integer size){
        return laborService.listLabor(page,size);
    }

    @PostMapping("/search")
    public ResponseMap searchLabor(@RequestBody SearchModel searchModel){
        return laborService.searchLabor(searchModel);
    }
    @GetMapping("/count")
    public ResponseMap countLabor(){
        return laborService.countLabor();
    }

    @GetMapping("/download/{page}/{size}")
    public void download(@PathVariable Integer page,@PathVariable Integer size, HttpServletResponse response) throws IOException {
        ExcelUtil.setExcelHeader(response,"人工成本列表");
        EasyExcel.write(response.getOutputStream(), Labor.class).sheet("人工成本列表").doWrite(laborService.exportList(page, size));
    }

    @PostMapping("/search/download")
    public void downloadSearch(@RequestBody SearchModel searchModel, HttpServletResponse response)throws IOException {
        ExcelUtil.setExcelHeader(response,"人工成本列表");
        EasyExcel.write(response.getOutputStream(), Labor.class).sheet("人工成本列表").doWrite(laborService.searchList(searchModel));
    }
}
