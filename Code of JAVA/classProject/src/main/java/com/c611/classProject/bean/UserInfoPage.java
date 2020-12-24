package com.c611.classProject.bean;

import java.util.List;

/**
 * @author Akili
 * @date 2020/12/23 15:39
 * @software IntelliJ IDEA
 */
public class UserInfoPage {
    private List<UserInfo> userInfoList;
    private int totalCount; //总数据条数
    private int totalPageCount;//总页数
    private int currentPage;//当前页码
    private int pageSize;//显示数据的条数

    public UserInfoPage() {
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
