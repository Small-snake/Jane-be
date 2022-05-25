package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
public class Base64Controller {

    @RequestMapping("/encoding")
    @ResponseBody()
    public String encoding(@RequestBody Map<String,String> args) {
        /*content*/
        String content = args.get("content");

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("content", java.util.Base64.getEncoder().encodeToString(content.getBytes()));
        return jsonObject.toJSONString();
    }




    @RequestMapping("/decoding")
    @ResponseBody
    public String decoding(@RequestBody Map<String,String> args){
        /*content*/
        String content = args.get("content");
        byte[] bytes = java.util.Base64.getDecoder().decode(content.getBytes());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", new String(bytes));
        return jsonObject.toJSONString();
    }

}
