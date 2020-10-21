package com.chenlw.webservice.hzbank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * xgbzj002-单位权限信息同步-响应报文
 *
 * @author chenlw 2020-09-27
 * @since 3.4
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "BFS_SERVER")
public class HzBankCorpPermissionInput {

    @JacksonXmlProperty(localName = "HEAD")
    private HzBankCommonHead head;

    @JacksonXmlProperty(localName = "RES_BODY")
    private ResBody resBody;

    public HzBankCommonHead getHead() {
        return head;
    }

    public void setHead(HzBankCommonHead head) {
        this.head = head;
    }

    public ResBody getResBody() {
        return resBody;
    }

    public void setResBody(ResBody resBodyTemp) {
        resBody = resBodyTemp;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResBody extends HzBankCommonResBody {

        @JacksonXmlProperty(localName = "LIST")
        private ListNode list;

        public ListNode getList() {
            return list;
        }

        public void setList(ListNode listTemp) {
            list = listTemp;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListNode {

        @JacksonXmlProperty(localName = "ROW")
        @JacksonXmlElementWrapper(localName = "ROW", useWrapping = false)
        private List<Row> row;

        public List<Row> getRow() {
            return row;
        }

        public void setRow(List<Row> rowListTemp) {
            row = rowListTemp;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Row {

        /**
         * 用户代码
         */
        @JacksonXmlProperty(localName = "USER_CODE")
        private String userCode;

        /**
         * 单位代码
         */
        @JacksonXmlProperty(localName = "CORP_CODE")
        private String corpCode;

        /**
         * 单位名称
         */
        @JacksonXmlProperty(localName = "CORP_NAME")
        private String corpName;

        /**
         * 结算权限是否有 1：有 0：无
         */
        @JacksonXmlProperty(localName = "NIS_AUTH")
        private String nisAuth;

        /**
         * 预算权限是否有 1：有    0：无
         */
        @JacksonXmlProperty(localName = "FBS_AUTH")
        private String fbsAuth;

        /**
         * 审批权限是否有 1：有  0：无
         */
        @JacksonXmlProperty(localName = "BAS_AUTH")
        private String basAuth;

        /**
         * 查询权限是否有 1：有 0：无
         */
        @JacksonXmlProperty(localName = "QUE_AUTH")
        private String queAuth;

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getCorpCode() {
            return corpCode;
        }

        public void setCorpCode(String corpCode) {
            this.corpCode = corpCode;
        }

        public String getCorpName() {
            return corpName;
        }

        public void setCorpName(String corpName) {
            this.corpName = corpName;
        }

        public String getNisAuth() {
            return nisAuth;
        }

        public void setNisAuth(String nisAuth) {
            this.nisAuth = nisAuth;
        }

        public String getFbsAuth() {
            return fbsAuth;
        }

        public void setFbsAuth(String fbsAuth) {
            this.fbsAuth = fbsAuth;
        }

        public String getBasAuth() {
            return basAuth;
        }

        public void setBasAuth(String basAuth) {
            this.basAuth = basAuth;
        }

        public String getQueAuth() {
            return queAuth;
        }

        public void setQueAuth(String queAuth) {
            this.queAuth = queAuth;
        }
    }

}
