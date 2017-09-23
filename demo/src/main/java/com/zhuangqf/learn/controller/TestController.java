package com.zhuangqf.learn.controller;

import com.riversoft.weixin.common.WxClient;
import com.zhuangqf.learn.config.VO.WxAppSetting;
import com.zhuangqf.learn.config.VO.WxClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zhuangqf on 9/21/17.
 */
@RestController
public class TestController {

    @Autowired
    private WxClientFactory mpWxClientFactory;

    @RequestMapping("test")
    public String context(String name){
        return mpWxClientFactory.get(name).getClientId();
    }


}
