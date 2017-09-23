package com.zhuangqf.learn.config.properties;
import com.zhuangqf.learn.config.VO.WxAppSetting;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by zhuangqf on 9/22/17.
 */
@ConfigurationProperties(prefix = "wechat")
public class WechatProperties {

    private List<WxAppSetting> mpApps;
    private List<WxAppSetting> qyApps;

    public List<WxAppSetting> getMpApps() {
        return mpApps;
    }

    public void setMpApps(List<WxAppSetting> mpApps) {
        this.mpApps = mpApps;
    }

    public List<WxAppSetting> getQyApps() {
        return qyApps;
    }

    public void setQyApps(List<WxAppSetting> qyApps) {
        this.qyApps = qyApps;
    }
}
