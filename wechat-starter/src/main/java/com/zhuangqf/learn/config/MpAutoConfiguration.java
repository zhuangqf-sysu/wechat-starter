package com.zhuangqf.learn.config;

import com.zhuangqf.learn.config.VO.WxAppSetting;
import com.zhuangqf.learn.config.VO.WxClientFactory;
import com.zhuangqf.learn.config.properties.WechatProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by zhuangqf on 9/23/17.
 */
@Configuration
@EnableConfigurationProperties(value = {WechatProperties.class})
@ConditionalOnBean(name="mpEndpoint")
public class MpAutoConfiguration {

    @Resource
    private Properties mpEndpoint;

    @Autowired
    private WechatProperties wechatProperties;

    @Bean
    public WxClientFactory mpWxClientFactory(){
        WxClientFactory wxClientFactory = new WxClientFactory();
        String url = mpEndpoint.getProperty("url.token.get");
        if(wechatProperties.getMpApps()!=null){
            for(WxAppSetting app:wechatProperties.getMpApps()){
                wxClientFactory.put(app.getName(),app.getAppSetting(),url);
            }
        }
        return wxClientFactory;
    }

}
