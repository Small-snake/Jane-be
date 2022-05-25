package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Encryption;
import com.example.demo.service.impl.EncryptionServiceImpl;
import com.example.demo.utils.UUIDGenerator;
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
 * @since 2022-05-24
 */
@Controller
@RequestMapping("/jane/encryption")
public class EncryptionController {
    @Autowired
    private EncryptionServiceImpl encryptionService;


    @RequestMapping("/putEncryption")
    @ResponseBody
    public String putEncryption(@RequestBody Map<String,String> args){
        /*username,encryption*/
        String username = args.get("username");
        String isEncryption = args.get("encryption");
        Encryption encryption = new Encryption();
        encryption.setIsencryption(isEncryption);
        encryption.setUsername(username);

        Encryption temp = encryptionService.queryEncryption(encryption);
        JSONObject jsonObject = new JSONObject();
        if(temp == null){
            encryption.setId(UUIDGenerator.getUUID());
            encryptionService.addEncryption(encryption);
            jsonObject.put("state","true");
            jsonObject.put("encryption",encryption.getIsencryption());
        } else {
            encryption.setId(temp.getId());
            encryptionService.updateEncryption(encryption);
            jsonObject.put("state","true");
            jsonObject.put("encryption",encryption.getIsencryption());
        }
        return jsonObject.toJSONString();
    }

    @RequestMapping("/getEncryption")
    @ResponseBody
    public String getEncryption(@RequestBody Map<String,String> args){
        /*username*/
        String username = args.get("username");
        Encryption encryption = new Encryption();
        encryption.setUsername(username);

        Encryption temp = encryptionService.queryEncryption(encryption);
        JSONObject jsonObject = new JSONObject();

        if(temp == null){
            encryption.setIsencryption("false");
            encryption.setId(UUIDGenerator.getUUID());
            encryptionService.addEncryption(encryption);
            jsonObject.put("state","true");
            jsonObject.put("encryption",encryption.getIsencryption());
        } else {

            jsonObject.put("state","true");
            jsonObject.put("encryption",temp.getIsencryption());
        }
        return jsonObject.toJSONString();

    }


}
