package com.c611.classProject.dao;

import com.c611.classProject.bean.Goods;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：yq
 * @description：商品查询接口
 * @date ：2020/12/21 12:44
 */
public interface IGoodsDao {
    Goods findGoodByID(int id) throws SQLException;

    Goods findGoodByName(String name) throws SQLException;

    List<Goods> findGoodsList() throws SQLException;

    List<Goods> findGoodsList(int page,int size) throws SQLException;

    boolean AddGood(Goods goods) throws SQLException;

    boolean UpdataGood(Goods goods) throws SQLException;

    boolean DeleteGoodByID(int id) throws SQLException;

    boolean DeleteGoodByName(String name) throws SQLException;

    int GetGoodsCount() throws SQLException;
}
