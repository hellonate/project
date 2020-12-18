package com.cmos.project.bean;

/**
 * 用户中奖日志
 *
 * @author lishenbo
 */
public class UserPrizeLog {
    private String activityName;            //活动名称
    private String openId;                  //openid
    private String phoneNum;                //手机号
    private String provinceCode;            //省份编码
    private String prizedTime;              //中奖时间(yyyy-MM-dd hh:mm:ss)
    private String channel;                 //中奖渠道
    private String prizeName;               //奖品名称
    private String prizeType;               //奖品类型（流量/话费/异业券/其它）

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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

    public String getPrizedTime() {
        return prizedTime;
    }

    public void setPrizedTime(String prizedTime) {
        this.prizedTime = prizedTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    @Override
    public String toString() {
        return
                activityName + "|" +
                        openId + "|" +
                        phoneNum + "|" +
                        provinceCode + "|" +
                        prizedTime + "|" +
                        channel + "|" +
                        prizeName + "|" +
                        prizeType;
    }


}
