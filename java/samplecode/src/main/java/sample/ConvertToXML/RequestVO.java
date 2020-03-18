package sample.ConvertToXML;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestVO {
    private String intfType;
    private String bsnsCode;
    private String propertyNo;
    private String rsvnRecvXml;
    private String userId;
    private String uperIp;
    private String langType;
    private String resultYN;
    private String resultMsg;
    private String resultRefCursor;

    public String getIntfType() {
        return intfType;
    }

    public void setIntfType(String intfType) {
        this.intfType = intfType;
    }

    public String getBsnsCode() {
        return bsnsCode;
    }

    public void setBsnsCode(String bsnsCode) {
        this.bsnsCode = bsnsCode;
    }

    public String getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(String propertyNo) {
        this.propertyNo = propertyNo;
    }

    public String getRsvnRecvXml() {
        return rsvnRecvXml;
    }

    public void setRsvnRecvXml(String rsvnRecvXml) {
        this.rsvnRecvXml = rsvnRecvXml;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUperIp() {
        return uperIp;
    }

    public void setUperIp(String uperIp) {
        this.uperIp = uperIp;
    }

    public String getLangType() {
        return langType;
    }

    public void setLangType(String langType) {
        this.langType = langType;
    }

    public String getResultYN() {
        return resultYN;
    }

    public void setResultYN(String resultYN) {
        this.resultYN = resultYN;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultRefCursor() {
        return resultRefCursor;
    }

    public void setResultRefCursor(String resultRefCursor) {
        this.resultRefCursor = resultRefCursor;
    }

}
