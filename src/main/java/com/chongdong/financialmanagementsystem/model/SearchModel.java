package com.chongdong.financialmanagementsystem.model;

import lombok.Data;

@Data
public class SearchModel {
    private String search;
    private Integer page;
    private Integer size;
    private String startTime;
    private String endTime;
}
