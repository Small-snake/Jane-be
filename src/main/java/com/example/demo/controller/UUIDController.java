package com.example.demo.controller;


import com.example.demo.result.UUIDResult;
import com.example.demo.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller

public class UUIDController {
    @Autowired
    private UUIDResult uuidResult;

    @RequestMapping("/getUUID")
    @ResponseBody
    public UUIDResult getUUID(){
        uuidResult.setUUID(UUIDGenerator.getUUID());
        uuidResult.setState("true");
        return uuidResult;
    }
}
