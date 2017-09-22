package com.zhuangqf.learn.config;

import com.zhuangqf.learn.config.VO.MpApp;
import com.zhuangqf.learn.config.VO.QyApp;
import com.zhuangqf.learn.config.properties.WechatProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuangqf on 9/18/17.
 */
@Configuration
@EnableConfigurationProperties(value = {WechatProperties.class})
public class WechatAutoConfiguration {

    @Autowired
    private WechatProperties wechatProperties;

    @Bean
    public WxClientFactory mpWxClientFactory(){
        WxClientFactory wxClientFactory = new WxClientFactory();
        if(wechatProperties.getMpApps()!=null){
            for(MpApp app:wechatProperties.getMpApps()){
                wxClientFactory.put(app.getName(),app.getAppSetting());
            }
        }
        return wxClientFactory;
    }

    @Bean
    public WxClientFactory QyWxClientFactory(){
        WxClientFactory wxClientFactory = new WxClientFactory();
        if(wechatProperties.getQyApps()!=null){
            for(QyApp app:wechatProperties.getQyApps()){
                wxClientFactory.put(app.getName(),app.getCorpSetting());
            }
        }
    }

}
