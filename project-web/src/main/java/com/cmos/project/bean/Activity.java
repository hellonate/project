package com.cmos.project.bean;

public class Activity {
    private String activityName;//活动名称
    private String openId;
    private String phoneNum;//手机号码
    private String provinceCode;//省份编码
    private String takePartTime; //参与时间
    private String takePartChannel;//参与渠道
    private String backUpField1;//备用字段1
    private String backUpField2;//备用字段2
    private String backUpField3;//备用字段3


    public Activity() {
        super();
    }

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

    public String getTakePartTime() {
        return takePartTime;
    }

    public void setTakePartTime(String takePartTime) {
        this.takePartTime = takePartTime;
    }

    public String getTakePartChannel() {
        return takePartChannel;
    }

    public void setTakePartChannel(String takePartChannel) {
        this.takePartChannel = takePartChannel;
    }

    public String getBackUpField1() {
        return backUpField1;
    }

    public void setBackUpField1(String backUpField1) {
        this.backUpField1 = backUpField1;
    }

    public String getBackUpField2() {
        return backUpField2;
    }

    public void setBackUpField2(String backUpField2) {
        this.backUpField2 = backUpField2;
    }

    public String getBackUpField3() {
        return backUpField3;
    }

    public void setBackUpField3(String backUpField3) {
        this.backUpField3 = backUpField3;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activityName == null) ? 0 : activityName.hashCode());
        result = prime * result + ((backUpField1 == null) ? 0 : backUpField1.hashCode());
        result = prime * result + ((backUpField2 == null) ? 0 : backUpField2.hashCode());
        result = prime * result + ((backUpField3 == null) ? 0 : backUpField3.hashCode());
        result = prime * result + ((openId == null) ? 0 : openId.hashCode());
        result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
        result = prime * result + ((provinceCode == null) ? 0 : provinceCode.hashCode());
        result = prime * result + ((takePartChannel == null) ? 0 : takePartChannel.hashCode());
        result = prime * result + ((takePartTime == null) ? 0 : takePartTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Activity other = (Activity) obj;
        if (activityName == null) {
            if (other.activityName != null)
                return false;
        } else if (!activityName.equals(other.activityName))
            return false;
        if (backUpField1 == null) {
            if (other.backUpField1 != null)
                return false;
        } else if (!backUpField1.equals(other.backUpField1))
            return false;
        if (backUpField2 == null) {
            if (other.backUpField2 != null)
                return false;
        } else if (!backUpField2.equals(other.backUpField2))
            return false;
        if (backUpField3 == null) {
            if (other.backUpField3 != null)
                return false;
        } else if (!backUpField3.equals(other.backUpField3))
            return false;
        if (openId == null) {
            if (other.openId != null)
                return false;
        } else if (!openId.equals(other.openId))
            return false;
        if (phoneNum == null) {
            if (other.phoneNum != null)
                return false;
        } else if (!phoneNum.equals(other.phoneNum))
            return false;
        if (provinceCode == null) {
            if (other.provinceCode != null)
                return false;
        } else if (!provinceCode.equals(other.provinceCode))
            return false;
        if (takePartChannel == null) {
            if (other.takePartChannel != null)
                return false;
        } else if (!takePartChannel.equals(other.takePartChannel))
            return false;
        if (takePartTime == null) {
            if (other.takePartTime != null)
                return false;
        } else if (!takePartTime.equals(other.takePartTime))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Activity [activityName=" + activityName + ", openId=" + openId + ", phoneNum=" + phoneNum
                + ", provinceCode=" + provinceCode + ", takePartTime=" + takePartTime + ", takePartChannel="
                + takePartChannel + ", backUpField1=" + backUpField1 + ", backUpField2=" + backUpField2
                + ", backUpField3=" + backUpField3 + "]";
    }

    public String disPlay() {
        return getActivityName() + "|" + getOpenId() + "|" + getPhoneNum() + "|" + getProvinceCode() + "|" + getTakePartTime() + "|" + getTakePartChannel() + "|" + getBackUpField1() + "|" + getBackUpField2() + "|" + getBackUpField3();
    }

}
