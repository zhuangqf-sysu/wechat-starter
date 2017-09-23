package com.zhuangqf.learn.VO;

import com.riversoft.weixin.common.AccessTokenHolder;
import com.riversoft.weixin.common.DefaultAccessTokenHolder;
import com.riversoft.weixin.common.WxClient;
import com.riversoft.weixin.mp.base.AppSetting;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhuangqf on 9/23/17.
 */
public class WxClientFactory {
    private ConcurrentHashMap<String, WxClient> wxClients = new ConcurrentHashMap<>();

    public void put(String name,AppSetting appSetting,String url) {
        if (wxClients.containsKey(name)) return;
        String clazz = appSetting.getTokenHolderClass();

        AccessTokenHolder accessTokenHolder = null;
        if(clazz == null || "".equals(clazz)) {
            accessTokenHolder = new DefaultAccessTokenHolder(url, appSetting.getAppId(), appSetting.getSecret());
        } else {
            try {
                accessTokenHolder = (AccessTokenHolder)Class.forName(clazz).newInstance();
                accessTokenHolder.setClientId(appSetting.getAppId());
                accessTokenHolder.setClientSecret(appSetting.getSecret());
                accessTokenHolder.setTokenUrl(url);
            } catch (Exception e) {
                accessTokenHolder = new DefaultAccessTokenHolder(url, appSetting.getAppId(), appSetting.getSecret());
            }
        }

        WxClient wxClient = new WxClient(appSetting.getAppId(), appSetting.getSecret(), accessTokenHolder);
        wxClients.putIfAbsent(name, wxClient);
    }

    public WxClient get(String name){
        return wxClients.get(name);
    }

}
