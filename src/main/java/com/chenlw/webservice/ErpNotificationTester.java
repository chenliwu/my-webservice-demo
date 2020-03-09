package com.chenlw.webservice;

import com.alibaba.fastjson.JSONObject;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author chenlw
 * @date 2020/03/06
 */
@WebService
public class ErpNotificationTester {

    public static final String JWS_SERVICE_URL = "http://192.168.0.193:9090/epp/services/ErpNotificationService";


    public static void main(String[] args) {
        testPublish1();
    }

    public static void testPublish1() {
        // 通过EndPoint(端点服务)发布一个WebService
        Endpoint.publish(JWS_SERVICE_URL, new ErpNotificationTester());
        System.out.println("发布成功!");
        // 发布成功后 在浏览器输入 http://192.168.0.193:9090/epp/services/ErpNotificationService?wsdl
    }


    public String returnNotificationSuccessfulResult(String requestData) {
        System.out.println("");
        System.out.println("returnNotificationSuccessfulResult");
        System.out.println(requestData);

        outputNotification(requestData);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("STATUS", "1");
        jsonObject.put("MESSAGE", "ok");
        return jsonObject.toString();
    }


    @WebMethod(exclude = true)
    public void outputNotification(String requestData) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestData);
            if (jsonObject.get("userList") != null) {
                System.out.println("userList:" + jsonObject.get("userList").toString());
            }
            if (jsonObject.get("content") != null) {
                System.out.println("content:" + jsonObject.get("content").toString());
            }
            if (jsonObject.get("type") != null) {
                System.out.println("type:" + jsonObject.get("type").toString());
                if ("1".equals(jsonObject.get("type"))) {
                    System.out.println("url：" + jsonObject.get("url"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("解析通知失败：" + e.getMessage());
        }

    }
}
