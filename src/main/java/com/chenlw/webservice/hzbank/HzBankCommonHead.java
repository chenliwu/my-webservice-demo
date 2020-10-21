package com.chenlw.webservice.hzbank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.UUID;

/**
 * 杭州银行 - 公共报文头
 *
 * @author chenlw 2020-09-27
 * @since 3.4
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HzBankCommonHead {

    /**
     * 组装 公共报文头
     *
     * @param serverType 交易代码
     * @param hostCstNo  集团客户号
     * @param hostOrpNo  企业操作员号（用户账号）
     * @return 公共报文头
     */
    public static HzBankCommonHead assembleHzBankCommonHead(String serverType,
                                                            String hostCstNo,
                                                            String hostOrpNo) {
        HzBankCommonHead hzBankCommonHead = new HzBankCommonHead();
        hzBankCommonHead.setSerivalId(UUID.randomUUID().toString());
        // 交易日期
        hzBankCommonHead.setTransactionDate("20201021");
        // 交易时间
        hzBankCommonHead.setTransactionTime("145900");
        // 交易代码
        hzBankCommonHead.setServerType(serverType);
        // 集团客户号
        hzBankCommonHead.setHostCstNo(hostCstNo);
        // 企业操作员
        hzBankCommonHead.setHostOrpNo(hostOrpNo);
        return hzBankCommonHead;
    }

    /**
     * 消息流水号
     */
    @JacksonXmlProperty(localName = "EBANK_SERIVAL_ID")
    private String serivalId;

    /**
     * 交易代码
     */
    @JacksonXmlProperty(localName = "SERVER_TYPE")
    private String serverType;

    /**
     * 交易日期  YYYYMMDD
     */
    @JacksonXmlProperty(localName = "TX_DATE")
    private String transactionDate;

    /**
     * 交易时间  HHmmss
     */
    @JacksonXmlProperty(localName = "TX_TIME")
    private String transactionTime;

    /**
     * 集团客户号
     */
    @JacksonXmlProperty(localName = "HOST_CST_NO")
    private String hostCstNo;

    /**
     * 企业操作员
     */
    @JacksonXmlProperty(localName = "HOST_OPR_NO")
    private String hostOrpNo;

    /**
     * 渠道号  默认01
     */
    @JacksonXmlProperty(localName = "TX_CHAN")
    private String channel = "01";

    /**
     * 渠道编号  默认01
     */
    @JacksonXmlProperty(localName = "TX_CHAN_NO")
    private String channelNo = "01";

    /**
     * 签名
     */
    @JacksonXmlProperty(localName = "SIGN_DATA")
    private String signData;

    public String getSerivalId() {
        return serivalId;
    }

    public void setSerivalId(String serivalId) {
        this.serivalId = serivalId;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getHostCstNo() {
        return hostCstNo;
    }

    public void setHostCstNo(String hostCstNo) {
        this.hostCstNo = hostCstNo;
    }

    public String getHostOrpNo() {
        return hostOrpNo;
    }

    public void setHostOrpNo(String hostOrpNo) {
        this.hostOrpNo = hostOrpNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }
}
