package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Encryption;
import com.example.demo.entity.Font;
import com.example.demo.mapper.EncryptionMapper;
import com.example.demo.mapper.FontMapper;
import com.example.demo.service.IEncryptionService;
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
 * @since 2022-05-24
 */
@Service
public class EncryptionServiceImpl extends ServiceImpl<EncryptionMapper, Encryption> implements IEncryptionService {
    @Autowired
    private EncryptionMapper encryptionMapper;
    public Encryption queryEncryption(Encryption encryption){

        HashMap<String,Object> map = new HashMap<>();
        map.put("username",encryption.getUsername());
        List<Encryption> encryptionList = encryptionMapper.selectByMap(map);
        if(encryptionList.size() > 0){
            return encryptionList.get(0);
        }
        return null;
    }

    public boolean addEncryption(Encryption encryption){


        int insert = encryptionMapper.insert(encryption);
        if(insert > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean updateEncryption(Encryption encryption){
        encryptionMapper.updateById(encryption);
        return true;
    }
}
