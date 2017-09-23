package com.zhuangqf.learn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhuangqf on 9/23/17.
 */
@Configurable
@AutoConfigureBefore({MpAutoConfiguration.class,QyAutoConfiguration.class})
public class EndpointAutoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(EndpointAutoConfiguration.class);

    private static final String WX_MP_ENDPOINT = "wx-mp-endpoint.properties";
    private static final String WX_QY_ENDPOINT = "wx-qy-endpoint.properties";

    @Bean
    @ConditionalOnResource(resources = {WX_MP_ENDPOINT})
    public Properties mpEndpoint(){
        return loadProperties(WX_MP_ENDPOINT);
    }

    @Bean
    @ConditionalOnResource(resources = {WX_QY_ENDPOINT})
    public Properties qyEndpoint(){
        return loadProperties(WX_QY_ENDPOINT);
    }


    private Properties loadProperties(String configFile){
        try {
            Properties properties = new Properties();
            InputStream inputStream = EndpointAutoConfiguration.class.getClassLoader().getResourceAsStream(configFile);
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            logger.error("cannot find resource wx-mp-endpoint.properties from classpath.");
            logger.error("wx error:",e);
            return null;
        }
    }

}
