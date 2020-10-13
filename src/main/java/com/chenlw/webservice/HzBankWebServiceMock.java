package com.chenlw.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author chenlw 2020-09-27
 * @since 3.0.0
 */
@WebService
public class HzBankWebServiceMock {

    public static final String JWS_SERVICE_URL = "http://192.168.1.54:9090/bfsServerWeb/services/BfsBankServer";


    //通过EndPoint(端点服务)发布一个WebService
    public static void main(String[] args) {
        testPublish1();
    }

    public static void testPublish1() {
        /*
            参数:1,本地的服务地址;
           2,提供服务的类;
      */
        Endpoint.publish(JWS_SERVICE_URL, new HzBankWebServiceMock());
        System.out.println("发布成功!");
        //发布成功后 在浏览器输入 http://192.168.1.54:9090/bfsServerWeb/services/BfsBankServer?wsdl
    }

    /**
     * 供客户端调用方法  该方法是非静态的，会被发布
     *
     * @param params 传入参数
     * @return String 返回结果
     */
    public String bfsBankServer(String params) {
        System.out.println("参数：" + params);
        return params;
    }

}
