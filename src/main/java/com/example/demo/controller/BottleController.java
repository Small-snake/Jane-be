package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Bottle;
import com.example.demo.service.impl.BottleServiceImpl;
import com.example.demo.utils.UUIDGenerator;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-22
 */
@Controller
@RequestMapping("/jane/bottle")
public class BottleController {
    @Autowired
    private BottleServiceImpl bottleService;

    @RequestMapping("/putBottle")
    @ResponseBody
    public String putBottle(@RequestBody Map<String,String> args){
        /*username,UUID*/
        String username = args.get("username");
        String uuid = args.get("UUID");

        Bottle bottle = new Bottle();
        bottle.setId(UUIDGenerator.getUUID());
        bottle.setUsername(username);
        bottle.setDiaryId(uuid);

        bottleService.addBottle(bottle);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","true");
        jsonObject.put("msg","漂流瓶添加成功！");

        return jsonObject.toJSONString();
    }

    @RequestMapping("/getBottle")
    @ResponseBody
    public String getBottle(@RequestBody Map<String,String> args){
        String username = args.get("username");
        Bottle bottle = new Bottle();
        bottle.setUsername(username);
        List<Bottle> list = bottleService.queryBottle(bottle);
        JSONObject jsonObject = new JSONObject();
        if(list == null || list.size() <= 0 ){
            jsonObject.put("state","false");
            jsonObject.put("msg","没有漂流瓶了！");

        } else {
            Random random = new Random();
            int num = random.nextInt(list.size());

            jsonObject.put("state","true");
            jsonObject.put("UUID",list.get(num).getDiaryId());
        }



        return jsonObject.toJSONString();
    }

}
