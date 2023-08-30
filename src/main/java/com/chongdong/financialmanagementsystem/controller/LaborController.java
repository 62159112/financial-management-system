package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.Labor;
import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.SearchModel;
import com.chongdong.financialmanagementsystem.service.LaborService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    public ResponseMap addLabor(@RequestBody Labor labor){
        return laborService.addLabor(labor);
    }

    @PutMapping
    public ResponseMap updateLabor(@RequestBody Labor labor){
        return laborService.updateLabor(labor);
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
}
