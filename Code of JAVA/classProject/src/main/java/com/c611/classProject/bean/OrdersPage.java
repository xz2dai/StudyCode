package com.c611.classProject.bean;

import java.util.List;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/23 19:19
 */
public class OrdersPage {
    private List<Orders> list;// 显示的数据
    private int totalCount;// 数据库总条数
    private int totalPageCount;// 总页数
    private int currentPage;// 当前页码
    private int pageSize;// 每页显示的数量

    public OrdersPage(){ }


    public List<Orders> getList() {
        return list;
    }
    public void setList(List<Orders> list) {
        this.list = list;
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
