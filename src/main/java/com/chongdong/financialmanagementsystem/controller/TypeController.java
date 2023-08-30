package com.chongdong.financialmanagementsystem.controller;

import com.chongdong.financialmanagementsystem.model.ResponseMap;
import com.chongdong.financialmanagementsystem.model.Type;
import com.chongdong.financialmanagementsystem.service.TypeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Resource
    TypeService typeService;
    @PostMapping
    public ResponseMap addType(@RequestBody Type Type){
        return typeService.addType(Type);
    }

    @PutMapping
    public ResponseMap updateType(@RequestBody Type Type){
        return typeService.updateType(Type);
    }

    @DeleteMapping("/{id}")
    public ResponseMap deleteType(@PathVariable Integer id){
        return typeService.deleteType(id);
    }

    @GetMapping("/list/{belong}/{page}/{size}")
    public ResponseMap listType(@PathVariable Integer belong,@PathVariable  Integer page,@PathVariable Integer size){
        return typeService.listType(belong,page,size);
    }

    @GetMapping("/list2/{belong}")
    public ResponseMap listTypeWithOutPage(@PathVariable Integer belong){
        return typeService.listTypeWithOutPage(belong);
    }
}
