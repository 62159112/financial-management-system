package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Expenses;
import com.chongdong.financialmanagementsystem.model.Operate;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.OperateService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    public ResponseMap addOperate(@RequestBody Operate operate){
        return operateService.addOperate(operate);
    }

    @PutMapping
    public ResponseMap updateOperate(@RequestBody Operate operate){
        return operateService.updateOperate(operate);
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
}
