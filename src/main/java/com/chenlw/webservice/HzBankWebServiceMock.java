package com.chenlw.webservice;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Map;

/**
 * @author chenlw 2020-09-27
 * @since 3.0.0
 */
@WebService
public class HzBankWebServiceMock {

    public static final String JWS_SERVICE_URL = "http://192.168.1.3:9090/bfsServerWeb/services/BfsBankServer";

    @Resource
    private WebServiceContext webServiceContext;

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

    /**
     * 同步审批信息
     *
     * @param params
     * @return
     */
    public String syncApproveInfo(String params) {
        // 读取HTTP请求头
        // webServiceContext.getMessageContext().get("com.sun.xml.internal.ws.api.message.packet.inbound.transport.headers")
        Map map = (Map) webServiceContext.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);

        System.out.println(webServiceContext.getUserPrincipal());
        System.out.println("同步审批信息！参数：" + params);
        String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<BODY>\n" +
                "    <HEAD>\n" +
                "        <!-- 消息流水号  随机号-->\n" +
                "        <EBANK_SERIVAL_ID>235353334</EBANK_SERIVAL_ID>\n" +
                "        <!-- 交易类型 -->\n" +
                "        <SERVER_TYPE>XGBZJ012</SERVER_TYPE>\n" +
                "        <!-- 交易日期  格式：YYYYMMDD-->\n" +
                "        <TX_DATE>20200916</TX_DATE>\n" +
                "        <!-- 交易时间  HHmmss-->\n" +
                "        <TX_TIME>151212</TX_TIME>\n" +
                "        <!-- 集团客户号 -->\n" +
                "        <HOST_CST_NO>800092953</HOST_CST_NO>\n" +
                "        <!-- 企业操作员 -->\n" +
                "        <HOST_OPR_NO>admin</HOST_OPR_NO>\n" +
                "        <!-- 渠道号 默认 01 -->\n" +
                "        <TX_CHAN>01</TX_CHAN>\n" +
                "        <!-- 渠道编号  默认 01 -->\n" +
                "        <TX_CHAN_NO>01</TX_CHAN_NO>\n" +
                "    </HEAD>\n" +
                "    <RES_BODY>\n" +
                "        <!-- 状态标识：成功是S,失败是F -->\n" +
                "        <RESULT_CODE>S</RESULT_CODE>\n" +
                "        <!-- 状态描述信息 -->\n" +
                "        <RESULT_MSG>操作成功</RESULT_MSG>\n" +
                "        <LIST>\n" +
                "            <ROW>\n" +
                "                <!--  单位代码 -->\n" +
                "                <CORP_CODE>1001</CORP_CODE>\n" +
                "                <!--  业务类别 fbsBudgetInput上报 fbsBudgetSuperadd追加 fbsBudgetProcess 执行-->\n" +
                "                <BUSINESS_CODE>fbsBudgetProcess</BUSINESS_CODE>\n" +
                "                <!--  操作类型 1，新增，2更新 -->\n" +
                "                <OPERATION_TYPE>2</OPERATION_TYPE>\n" +
                "                <!--  审批 任务节点 -->\n" +
                "                <LIST_TASK>\n" +
                "                    <ROW>\n" +
                "                        <!--  审批节点名称 -->\n" +
                "                        <NAME>一级审批</NAME>\n" +
                "                        <!--  审批节点审批顺序 -->\n" +
                "                        <ORDER>0</ORDER>\n" +
                "                        <!--  审批人,使用;分隔-->\n" +
                "                        <LIST_ASSIGN>admin;1000;</LIST_ASSIGN>\n" +
                "                    </ROW>\n" +
                "                    <ROW>\n" +
                "                        <!--  审批节点名称 -->\n" +
                "                        <NAME>二级审批</NAME>\n" +
                "                        <!--  审批节点审批顺序 -->\n" +
                "                        <ORDER>1</ORDER>\n" +
                "                        <!--  审批人,使用;分隔-->\n" +
                "                        <LIST_ASSIGN>admin;1000;</LIST_ASSIGN>\n" +
                "                    </ROW>\n" +
                "                </LIST_TASK>\n" +
                "            </ROW>\n" +
                "            <ROW>\n" +
                "                <!--  单位代码 -->\n" +
                "                <CORP_CODE>1002</CORP_CODE>\n" +
                "                <!--  业务类别 fbsBudgetInput上报 fbsBudgetSuperadd追加 fbsBudgetProcess 执行-->\n" +
                "                <BUSINESS_CODE>fbsBudgetProcess</BUSINESS_CODE>\n" +
                "                <!--  操作类型 1，新增，2更新 -->\n" +
                "                <OPERATION_TYPE>1</OPERATION_TYPE>\n" +
                "                <!--  审批 任务节点 -->\n" +
                "                <LIST_TASK>\n" +
                "                    <ROW>\n" +
                "                        <!--  审批节点名称 -->\n" +
                "                        <NAME>一级审批</NAME>\n" +
                "                        <!--  审批节点审批顺序 -->\n" +
                "                        <ORDER>0</ORDER>\n" +
                "                        <!--  审批人,使用;分隔-->\n" +
                "                        <LIST_ASSIGN>admin;1000;</LIST_ASSIGN>\n" +
                "                    </ROW>\n" +
                "                    <ROW>\n" +
                "                        <!--  审批节点名称 -->\n" +
                "                        <NAME>二级审批</NAME>\n" +
                "                        <!--  审批节点审批顺序 -->\n" +
                "                        <ORDER>1</ORDER>\n" +
                "                        <!--  审批人,使用;分隔-->\n" +
                "                        <LIST_ASSIGN>admin;1000;</LIST_ASSIGN>\n" +
                "                    </ROW>\n" +
                "                </LIST_TASK>\n" +
                "            </ROW>\n" +
                "        </LIST>\n" +
                "    </RES_BODY>\n" +
                "</BODY>\n";
        return responseXml;
    }

    /**
     * 单位权限信息同步
     *
     * @param params
     * @return
     */
    public String syncCorpPermission(String params) {
        System.out.println("单位权限信息同步！参数：" + params);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<BFS_SERVER>\n" +
                "\t<HEAD>\n" +
                "\t\t<!-- 消息流水号  随机流水号-->\n" +
                "\t\t<EBANK_SERIVAL_ID>5533434343</EBANK_SERIVAL_ID>\n" +
                "\t\t<!-- 交易类型 -->\n" +
                "\t\t<SERVER_TYPE>XGBZJ002</SERVER_TYPE>\n" +
                "\t\t<!-- 交易日期  格式 YYYYMMDD -->\n" +
                "\t\t<TX_DATE>20200916</TX_DATE>\n" +
                "\t\t<!-- 交易时间  格式 HHmmss -->\n" +
                "\t\t<TX_TIME>151818</TX_TIME>\n" +
                "\t\t<!-- 集团客户号 -->\n" +
                "\t\t<HOST_CST_NO>800092953</HOST_CST_NO>\n" +
                "\t\t<!-- 企业操作员 -->\n" +
                "\t\t<HOST_OPR_NO>cxy01</HOST_OPR_NO>\n" +
                "\t\t<!-- 渠道号 默认01 -->\n" +
                "\t\t<TX_CHAN>01</TX_CHAN>\n" +
                "\t\t<!-- 渠道编号 默认01 -->\n" +
                "\t\t<TX_CHAN_NO>01</TX_CHAN_NO>\n" +
                "\t</HEAD>\n" +
                "\t<RES_BODY>\t\n" +
                "        <!-- 返回结果  S:成功 F:失败-->\n" +
                "        <RESULT_CODE>S</RESULT_CODE>\n" +
                "        <!-- 返回信息-->\n" +
                "        <RESULT_MSG></RESULT_MSG>\n" +
                "\t\t<LIST>\n" +
                "\t\t\t<ROW>\n" +
                "\t\t\t\t<!--  用户代码 -->\n" +
                "\t\t\t\t<USER_CODE>cxy01</USER_CODE>\n" +
                "\t\t\t\t<!--  单位代码 -->\n" +
                "\t\t\t\t<CORP_CODE>1001</CORP_CODE>\n" +
                "\t\t\t\t<!--  单位名称 -->\n" +
                "\t\t\t\t<CORP_NAME>(1001)海王深圳分公司</CORP_NAME>\n" +
                "\t\t\t\t<!--  结算权限是否有 1：有 0：无 -->\n" +
                "\t\t\t\t<NIS_AUTH>0</NIS_AUTH>\n" +
                "\t\t\t\t<!-- 预算权限是否有 1：有    0：无 -->\n" +
                "\t\t\t\t<FBS_AUTH>1</FBS_AUTH>\n" +
                "\t\t\t\t<!-- 审批权限是否有 1：有  0：无 -->\n" +
                "\t\t\t\t<BAS_AUTH>1</BAS_AUTH>\n" +
                "\t\t\t\t<!-- 查询权限是否有 1：有 0：无 -->\n" +
                "\t\t\t\t<QUE_AUTH>1</QUE_AUTH>\n" +
                "\t\t\t</ROW>\n" +
                "\t\t\t<ROW>\n" +
                "\t\t\t\t<!--  用户代码 -->\n" +
                "\t\t\t\t<USER_CODE>cxy02</USER_CODE>\n" +
                "\t\t\t\t<!--  单位代码 -->\n" +
                "\t\t\t\t<CORP_CODE>1001</CORP_CODE>\n" +
                "\t\t\t\t<!--  单位名称 -->\n" +
                "\t\t\t\t<CORP_NAME>(1001)海王深圳分公司</CORP_NAME>\n" +
                "\t\t\t\t<!--  结算权限是否有 1：有 0：无 -->\n" +
                "\t\t\t\t<NIS_AUTH>0</NIS_AUTH>\n" +
                "\t\t\t\t<!-- 预算权限是否有 1：有    0：无 -->\n" +
                "\t\t\t\t<FBS_AUTH>1</FBS_AUTH>\n" +
                "\t\t\t\t<!-- 审批权限是否有 1：有  0：无 -->\n" +
                "\t\t\t\t<BAS_AUTH>1</BAS_AUTH>\n" +
                "\t\t\t\t<!-- 查询权限是否有 1：有 0：无 -->\n" +
                "\t\t\t\t<QUE_AUTH>1</QUE_AUTH>\n" +
                "\t\t\t</ROW>\n" +
                "\t\t</LIST>\n" +
                "\t</RES_BODY>\n" +
                "</BFS_SERVER>\n";
    }

}
