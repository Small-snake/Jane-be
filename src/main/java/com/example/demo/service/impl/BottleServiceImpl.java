package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Bottle;
import com.example.demo.entity.Font;
import com.example.demo.mapper.BottleMapper;
import com.example.demo.mapper.FontMapper;
import com.example.demo.service.IBottleService;
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
public class BottleServiceImpl extends ServiceImpl<BottleMapper, Bottle> implements IBottleService {
    @Autowired
    private BottleMapper bottleMapper;
    public List<Bottle> queryBottle(Bottle bottle){
        QueryWrapper<Bottle> wrapper = new QueryWrapper<>();
        wrapper.ne("username",bottle.getUsername());
        List<Bottle> bottleList = bottleMapper.selectList(wrapper);
       return bottleList;
    }

    public boolean addBottle(Bottle bottle){

        int insert = bottleMapper.insert(bottle);
        if(insert > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteBottle(Bottle bottle){
        bottleMapper.deleteById(bottle);
        return true;
    }
}
