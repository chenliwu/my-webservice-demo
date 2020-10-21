package com.chenlw.webservice.hzbank;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 杭州银行 - 公共报文响应体
 *
 * @author chenlw 2020-10-14
 * @since 3.4
 */
public class HzBankCommonResBody {

    /**
     * 返回结果  S:成功 F:失败
     */
    @JacksonXmlProperty(localName = "RESULT_CODE")
    private String resultCode;

    /**
     * 返回信息
     */
    @JacksonXmlProperty(localName = "RESULT_MSG")
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
