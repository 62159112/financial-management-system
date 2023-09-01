package com.chongdong.financialmanagementsystem.utils;


import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
 
/**
 * @author qx
 * @date 2023/7/6
 * @des Excel工具类
 */
public class ExcelUtil {
 
    /**
     * Excel头部导出封装
     *
     * @param response
     * @param rawFileName
     * @throws UnsupportedEncodingException
     */
    public static void setExcelHeader(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename" + fileName + ".xlsx");
    }


}