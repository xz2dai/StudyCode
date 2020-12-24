package com.c611.classProject.service;

import com.c611.classProject.bean.Goods;
import com.c611.classProject.bean.GoodsPageBean;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsService {
    Goods findGoodByID(int id) throws SQLException;

    Goods findGoodByName(String name) throws SQLException;

    List<Goods> findGoodsList() throws SQLException;

    boolean AddGood(Goods goods) throws SQLException;

    boolean UpdataGood(Goods goods) throws SQLException;

    boolean DeleteGoodByID(int id) throws SQLException;

    boolean DeleteGoodByName(String name) throws SQLException;

    GoodsPageBean getGoodsPageBean(int page,int size) throws SQLException;
}
