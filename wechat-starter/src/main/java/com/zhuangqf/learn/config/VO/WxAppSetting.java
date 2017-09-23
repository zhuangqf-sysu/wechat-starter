package com.zhuangqf.learn.config.VO;

import com.riversoft.weixin.mp.base.AppSetting;

/**
 * Created by zhuangqf on 9/23/17.
 */
public class WxAppSetting {
    private String name;
    private AppSetting appSetting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppSetting getAppSetting() {
        return appSetting;
    }

    public void setAppSetting(AppSetting appSetting) {
        this.appSetting = appSetting;
    }
}
