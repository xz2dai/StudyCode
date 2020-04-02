package com.xz2dai.bean;

/**
 * 小区数据接受对象转换实现类
 */
public class ResidentialQuarter {
    private int id;
    private String communityName;//小区名称
    private String communityAddress;//小区地址
    private double longitude;//经度
    private double latitude;//纬度
    private int totalNumPaks;//空闲停车位总数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTotalNumPaks() {
        return totalNumPaks;
    }

    public void setTotalNumPaks(int totalNumPaks) {
        this.totalNumPaks = totalNumPaks;
    }
}
