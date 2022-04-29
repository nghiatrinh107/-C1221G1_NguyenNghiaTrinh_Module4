package com.codegym.service.impl;

import com.codegym.service.ITranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TranslateService implements ITranslateService {
    @Override
    public String translate(String string) {
        Map<String,String> dic = new HashMap<>();
        dic.put("stupid","tbg");
        dic.put("computer","máy tính");
        dic.put("animal","Giảng");
        dic.put("book","sách");
        dic.put("class","lớp");
        String result = dic.get(string);
        if(result == null){
            return "ko tìm thấy";
        }
        return result;
    }
}
