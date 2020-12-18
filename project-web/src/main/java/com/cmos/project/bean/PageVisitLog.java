package com.cmos.project.bean;

/**
 * 页面访问日志
 */
public class PageVisitLog {
    private String activityName;             //活动名称
    private String channel;                  //参与渠道
    private String openId;                   //openid
    private String phoneNum;                 //手机号
    private String provinceCode;             //省份编码
    private String pageVisitTime;            //页面访问时间	yyyy-MM-dd hh:mm:ss
    private String pageName;                 //页面名称
    private String backup1;                  //备用字段1
    private String backup2;                  //备用字段2

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getPageVisitTime() {
        return pageVisitTime;
    }

    public void setPageVisitTime(String pageVisitTime) {
        this.pageVisitTime = pageVisitTime;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1;
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }

    @Override
    public String toString() {
        return activityName + "|" + channel + "|" + openId + "|" + phoneNum + "|" + provinceCode + "|" +
                pageVisitTime + "|" +
                pageName + "|" +
                backup1 + "|" +
                backup2;
    }
}
