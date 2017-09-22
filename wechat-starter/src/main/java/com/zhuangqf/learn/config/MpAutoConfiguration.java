package com.zhuangqf.learn.config;

import com.riversoft.weixin.common.WxClient;
import com.riversoft.weixin.mp.card.Cards;
import com.riversoft.weixin.mp.care.Accounts;
import com.riversoft.weixin.mp.care.CareMessages;
import com.riversoft.weixin.mp.jsapi.JsAPIs;
import com.riversoft.weixin.mp.media.Materials;
import com.riversoft.weixin.mp.media.Medias;
import com.riversoft.weixin.mp.menu.Menus;
import com.riversoft.weixin.mp.message.MpMessages;
import com.riversoft.weixin.mp.oauth2.MpOAuth2s;
import com.riversoft.weixin.mp.poi.Pois;
import com.riversoft.weixin.mp.shop.Orders;
import com.riversoft.weixin.mp.stat.Stats;
import com.riversoft.weixin.mp.template.Templates;
import com.riversoft.weixin.mp.ticket.Tickets;
import com.riversoft.weixin.mp.url.Urls;
import com.riversoft.weixin.mp.user.BlackLists;
import com.riversoft.weixin.mp.user.Groups;
import com.riversoft.weixin.mp.user.Tags;
import com.riversoft.weixin.mp.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuangqf on 9/18/17.
 */
//@Configuration
//@AutoConfigureAfter({WechatAutoConfiguration.class})
//@ConditionalOnBean(name = "mpWxClient")
public class MpAutoConfiguration {

    @Autowired
    private WxClient mpWxClient;

    /**
     * 自定义菜单管理
     * @Bean mpMenus
     */
    @Bean("mpMenus")
    public Menus mpMenus(){
        Menus.defaultMenus().setWxClient(mpWxClient);
        return Menus.defaultMenus();
    }

    /**
     * 群发接口
     * @Bean mpMessages
     */
    @Bean("mpMessages")
    public MpMessages mpMessages() {
        MpMessages.defaultMpMessages().setWxClient(mpWxClient);
        return MpMessages.defaultMpMessages();
    }

    /**
     * Urls 管理
     * @Bean mpUrls
     * */
    @Bean("mpUrls")
    public Urls mpUrls(){
        Urls.defaultUrls().setWxClient(mpWxClient);
        return Urls.defaultUrls();
    }

    /**
     * 永久素材管理
     * @Bean mpMaterials
     */
    @Bean("mpMaterials")
    public Materials mpMaterials(){
        Materials.defaultMaterials().setWxClient(mpWxClient);
        return Materials.defaultMaterials();
    }


    /**
     * 临时素材管理
     * 1、对于临时素材，每个素材（media_id）会在开发者上传或粉丝发送到微信服务器3天后自动删除（
     * 所以用户发送给开发者的素材，若开发者需要，应尽快下载到本地），以节省服务器资源。
     * 2、media_id是可复用的。
     * 3、素材的格式大小等要求与公众平台官网一致。
     * 具体是，图片大小不超过2M，支持bmp/png/jpeg/jpg/gif格式，
     * 语音大小不超过5M，长度不超过60秒，支持mp3/wma/wav/amr格式
     * @Bean mpMedias
     */
    @Bean("mpMedias")
    public Medias mpMedias(){
        Medias.defaultMedias().setWxClient(mpWxClient);
        return Medias.defaultMedias();
    }

    /**
     * 卡券接口
     * @Bean mpCards
     */
    @Bean("mpCards")
    public Cards mpCards(){
        Cards.defaultCards().setWxClient(mpWxClient);
        return Cards.defaultCards();
    }

    /**
     * 客服账号管理
     * @Bean mpAccounts
     */
    @Bean("mpAccounts")
    public Accounts mpAccounts(){
        Accounts.defaultAccounts().setWxClient(mpWxClient);
        return Accounts.defaultAccounts();
    }

    /**
     * 客服接口发送消息
     * @Bean mpCareMessages
     */
    @Bean("mpCareMessages")
    public CareMessages mpCareMessages(){
        CareMessages.defaultCareMessages().setWxClient(mpWxClient);
        return CareMessages.defaultCareMessages();
    }

    /**
     * 公众号OAuth API
     * @Bean mpOAuth2s
     */
    @Bean
    public MpOAuth2s mpOAuth2s(){
        MpMessages.defaultMpMessages().setWxClient(mpWxClient);
        return MpOAuth2s.defaultOAuth2s();
    }


    /**
     * 门店接口 V2.3
     * POI: 兴趣点
     * @Bean mpPois
     */
    @Bean("mpPois")
    public Pois mpPois(){
        Pois.defaultPois().setWxClient(mpWxClient);
        return Pois.defaultPois();
    }

    /**
     * 订单管理相关接口
     * @Bean mpOrders
     */
    @Bean("mpOrders")
    public Orders mpOrders(){
        Orders.defaultOrders().setWxClient(mpWxClient);
        return Orders.defaultOrders();
    }

    /**
     * 数据统计接口
     * @Bean mpStats
     * */
    @Bean("mpStats")
    public Stats mpStats(){
        Stats.defaultStats().setWxClient(mpWxClient);
        return Stats.defaultStats();
    }

    /**
     * 模板消息API
     * @Bean mpTemplates
     */
    @Bean("mpTemplates")
    public Templates mpTemplates(){
        Templates.defaultTemplates().setWxClient(mpWxClient);
        return Templates.defaultTemplates();
    }

    /**
     *  二维码
     *  @Bean mpTickets
     **/
    @Bean("mpTickets")
    public Tickets mpTickets(){
        Tickets.defaultTickets().setWxClient(mpWxClient);
        return Tickets.defaultTickets();
    }

    /**
     * 用户管理
     * @Bean mpUsers
     */
    @Bean("mpUsers")
    public Users mpUsers() {
        Users.defaultUsers().setWxClient(mpWxClient);
        return Users.defaultUsers();
    }

    /**
     *  用户标签
     *  @Bean mpTags
     **/
    @Bean("mpTags")
    public Tags mpTags(){
        Tags.defaultTags().setWxClient(mpWxClient);
        return Tags.defaultTags();
    }


    /**
     * 用户分组
     * @Bean mpGroups
     * */
    @Bean("mpGroups")
    public Groups mpGroups(){
        Groups.defaultGroups().setWxClient(mpWxClient);
        return Groups.defaultGroups();
    }


    /**
     * 黑名单管理
     * @Bean mpBlackLists
     */
    @Bean("mpBlackLists")
    public BlackLists mpBlackLists() {
        BlackLists.defaultBlackLists().setWxClient(mpWxClient);
        return BlackLists.defaultBlackLists();
    }

    /**
     * 微信JSAPI
     * @Bean mpJsAPIs
     **/
    @Bean("mpJsAPIs")
    public JsAPIs mpJsAPIs(){
        JsAPIs.defaultJsAPIs().setWxClient(mpWxClient);
        return JsAPIs.defaultJsAPIs();
    }

}
