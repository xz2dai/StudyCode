package com.c611.classProject.bean;


import java.util.List;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/23 15:09
 */
public class GoodsPageBean {
    private List<Goods> goodsList;
    private long TotalCount;
    private int CurrentPage;
    private int size;
    private int TotalPageCount;

    public GoodsPageBean(){

    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public long getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(long totalCount) {
        TotalCount = totalCount;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPageCount() {
        return TotalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        TotalPageCount = totalPageCount;
    }
}
