package com.zhuangqf.learn.config.properties;
import com.riversoft.weixin.mp.base.AppSetting;
import com.riversoft.weixin.qy.base.CorpSetting;
import com.zhuangqf.learn.config.VO.MpApp;
import com.zhuangqf.learn.config.VO.QyApp;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by zhuangqf on 9/22/17.
 */
@ConfigurationProperties(prefix = "wechat")
public class WechatProperties {

    private List<MpApp> mpApps;
    private List<QyApp> qyApps;

    public List<MpApp> getMpApps() {
        return mpApps;
    }

    public void setMpApps(List<MpApp> mpApps) {
        this.mpApps = mpApps;
    }

    public List<QyApp> getQyApps() {
        return qyApps;
    }

    public void setQyApps(List<QyApp> qyApps) {
        this.qyApps = qyApps;
    }
}
