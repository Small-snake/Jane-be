package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Diary;
import com.example.demo.entity.Font;
import com.example.demo.mapper.DiaryMapper;
import com.example.demo.service.IDiaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-22
 */
@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements IDiaryService {
    @Autowired
    private DiaryMapper diaryMapper;
    public List<Diary> queryDiary(Diary diary){

        HashMap<String,Object> map = new HashMap<>();
        //map.put("username",diary.getUsername());
        List<Diary> diaryList = diaryMapper.selectByMap(map);
        /*System.out.println(diaryList.size());
        for(int i=0;i<4;i++)
        System.out.println(diaryList.get(i));*/
        return diaryList;
    }

    public boolean addDiary(Diary diary){
        int insert = diaryMapper.insert(diary);
        if(insert > 0){
            return true;
        } else {
            return false;
        }
    }

   /* public boolean updateDiary(Diary diary){
       *//* UpdateWrapper<Diary> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username",font.getUsername());
        fontMapper.update(font,updateWrapper);*//*
        return true;
    }*/
}
