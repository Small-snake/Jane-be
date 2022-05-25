package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Font;
import com.example.demo.result.FontResult;
import com.example.demo.service.impl.FontServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-22
 */
@Controller
@RequestMapping("/jane/font")
public class FontController {
    @Autowired
    private FontResult fontResult;
    @Autowired
    private FontServiceImpl fontService;



    @RequestMapping("/findFont")
    @ResponseBody
    public FontResult findFont(@RequestBody Map<String,String> args){
        /*请求至少包含username*/
        String username = args.get("username");
        Font font = new Font();
        font.setUsername(username);
        Font temp = fontService.queryFont(font);
        if(temp == null) {
            font.setFont("默认字体");
            fontService.addFont(font);
            fontResult.setFont("默认字体");
            fontResult.setState("true");
        } else {
            if(temp.getFont().equals("默认字体")){
                fontResult.setState("true");
                fontResult.setFont("默认字体");
            } else{
                fontResult.setSrc(temp.getSrc());
                fontResult.setState("true");
                fontResult.setFont(font.getFont());
            }
        }
        return fontResult;
    }

    @RequestMapping("/changeFont")
    @ResponseBody
    public String changeFont(@RequestBody Map<String,String> args){
        /*请求至少包含username,font的名字和src*/
        String username = args.get("username");
        String fontName = args.get("font");
        String src = args.get("src");

        Font font = new Font();
        font.setFont(fontName);
        font.setUsername(username);
        font.setSrc(src);
        Font temp = fontService.queryFont(font);
        if(temp == null){
            fontService.addFont(font);
        } else {
            fontService.updateFont(font);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","true");
        jsonObject.put("msg","修改字体成功!");
        return jsonObject.toJSONString();
    }

}
