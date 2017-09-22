package com.zhuangqf.learn.config.VO;

import com.riversoft.weixin.qy.base.CorpSetting;

/**
 * Created by zhuangqf on 9/23/17.
 */
public class QyApp {
    private String name;
    private CorpSetting corpSetting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CorpSetting getCorpSetting() {
        return corpSetting;
    }

    public void setCorpSetting(CorpSetting corpSetting) {
        this.corpSetting = corpSetting;
    }
}
