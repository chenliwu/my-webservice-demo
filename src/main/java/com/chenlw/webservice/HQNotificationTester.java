package com.chenlw.webservice;

import com.alibaba.fastjson.JSONObject;
import com.chenlw.webservice.utils.Base64;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.nio.charset.StandardCharsets;

/**
 * @author chenlw
 * @date 2020/03/06
 */
@WebService
public class HQNotificationTester {

    public static final String JWS_SERVICE_URL = "http://192.168.0.193:9090/epp/services/WeixinServerForSendTouser";


    public static void main(String[] args) {
        testPublish1();
    }

    public static void testPublish1() {
        // 通过EndPoint(端点服务)发布一个WebService
        Endpoint.publish(JWS_SERVICE_URL, new HQNotificationTester());
        System.out.println("发布成功!");
        // 发布成功后 在浏览器输入 http://192.168.0.193:9090/epp/services/WeixinServerForSendTouser?wsdl
    }


    /**
     * 供客户端调用方法  该方法是非静态的，会被发布
     * @param requestData
     * @return
     */
    public String returnNotificationSuccessfulResult(String requestData) {
        System.out.println("");
        System.out.println("returnNotificationSuccessfulResult");
        System.out.println(requestData);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errcode", 0);
        jsonObject.put("errmsg", "ok");
        jsonObject.put("invaliduser", "");
        return jsonObject.toString();
    }

    /**
     * 供客户端调用方法  该方法是非静态的，会被发布
     * @param requestData
     * @return
     */
    public String returnLinkNotificationSuccessfulResult(String requestData) {
        System.out.println("");
        System.out.println("returnLinkNotificationSuccessfulResult");
        System.out.println(requestData);

        outputLinkNotification(requestData);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "S");
        jsonObject.put("msg", "ok");
        jsonObject.put("invaliduser", "");
        return jsonObject.toString();
    }


    @WebMethod(exclude = true)
    public void outputLinkNotification(String requestData) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestData);
            if (jsonObject.get("respUrl") != null) {
                String respUrl = Base64.byteArrayToBase64(jsonObject.get("respUrl").toString().getBytes(StandardCharsets.UTF_8.displayName()));
                System.out.println("业务详情跳转地址：" + respUrl);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("解析通知失败：" + e.getMessage());
        }

    }




    /**
     * 方法上加@WebMentod(exclude=true)后，此方法不被发布；
     *
     * @param name
     * @return
     */
    @WebMethod(exclude = true)
    public String getHello(String name) {
        return "你好！ " + name;
    }

    /**
     * 静态方法不会被发布
     *
     * @param name
     * @return
     */
    public static String getString(String name) {
        return "再见！" + name;
    }
}
