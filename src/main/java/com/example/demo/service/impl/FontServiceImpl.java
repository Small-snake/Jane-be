package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Font;
import com.example.demo.entity.User;
import com.example.demo.mapper.FontMapper;
import com.example.demo.service.IFontService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class FontServiceImpl extends ServiceImpl<FontMapper, Font> implements IFontService {
    @Autowired
    private FontMapper fontMapper;
    public Font queryFont(Font font){

        HashMap<String,Object> map = new HashMap<>();
        map.put("username",font.getUsername());
        List<Font> fontList = fontMapper.selectByMap(map);
        if(fontList.size() > 0){
            return fontList.get(0);
        }
        return null;
    }

    public boolean addFont(Font font){


        int insert = fontMapper.insert(font);
        if(insert > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean updateFont(Font font){
        UpdateWrapper<Font> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username",font.getUsername());
        fontMapper.update(font,updateWrapper);
        return true;
    }
}
