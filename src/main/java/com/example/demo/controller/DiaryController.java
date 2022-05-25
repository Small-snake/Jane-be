package com.example.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Diary;
import com.example.demo.result.DiaryResult;
import com.example.demo.service.impl.DiaryServiceImpl;
import com.example.demo.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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
@RequestMapping("/jane/diary")
public class DiaryController {
    @Autowired
    private DiaryServiceImpl diaryService;
    @Autowired
    private DiaryResult diaryResult;

    @RequestMapping("/uploadDiary")
    @ResponseBody
    public String uploadDiary(@RequestBody Map<String,String> args){
        /*username,content,title(默认日期日期)*/
        String username = args.get("username");
        String content = args.get("content");
        String title = args.get("title");
        String uuid = UUIDGenerator.getUUID();

        Diary diary = new Diary();
        diary.setContent(content);
        diary.setUsername(username);
        diary.setTitle(title);
        diary.setId(uuid);


        JSONObject jsonObject = new JSONObject();

        if(diaryService.addDiary(diary)){
            jsonObject.put("state","true");
            jsonObject.put("msg","日记保存成功！");
            jsonObject.put("UUID",uuid);

        } else{
            jsonObject.put("state","false");
            jsonObject.put("msg","日记保存失败！");
            jsonObject.put("UUID",uuid);
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping("/getDiary")
    @ResponseBody
    public String getDiary(@RequestBody Map<String,String> args){
        /*username*/
        String username = args.get("username");
        Diary diary = new Diary();
        diary.setUsername(username);
        List<Diary> diaryList = diaryService.queryDiary(diary);

        JSONArray jsonArray = new JSONArray();

        if(diaryList.size() > 0){
            for(int i=0;i<diaryList.size();i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("username",diaryList.get(i).getUsername());
                jsonObject.put("content",diaryList.get(i).getContent());
                jsonObject.put("title",diaryList.get(i).getTitle());
                jsonObject.put("UUID",diaryList.get(i).getId());
                jsonObject.put("state","true");
                jsonArray.set(i,jsonObject);
            }
        } else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state","false");
            jsonObject.put("msg","日记为空！");
            jsonArray.set(0,jsonObject);
        }
        return jsonArray.toJSONString();

    }


}
