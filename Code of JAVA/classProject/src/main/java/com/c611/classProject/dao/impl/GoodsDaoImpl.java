package com.c611.classProject.dao.impl;

import com.c611.classProject.Utils.C3P0Utils;
import com.c611.classProject.bean.Goods;
import com.c611.classProject.dao.IGoodsDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：yq
 * @description：商品操作Dao
 * @date ：2020/12/21 12:48
 */
public class GoodsDaoImpl implements IGoodsDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public Goods findGoodByID(int id)throws SQLException {
        String sql = "select * from goods where GoodID=?";
        return  queryRunner.query(sql, new BeanHandler<Goods>(Goods.class),id);
    }

    @Override
    public Goods findGoodByName(String name)throws SQLException {
        String sql = "select * from goods where GoodName=?";
        return  queryRunner.query(sql, new BeanHandler<Goods>(Goods.class),name);
    }

    @Override
    public List<Goods> findGoodsList()throws SQLException {
        String sql = "select * from goods";
        return  queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
    }

    @Override
    public boolean AddGood(Goods goods)throws SQLException {
        String sql = "insert into goods values (?,?,?,?,?,?)";
        Object[] params={
                goods.getGoodID(),
                goods.getGoodName(),
                goods.getGoodPrice(),
                goods.getGoodDescribe(),
                goods.getGoodStatus(),
                goods.getGoodType()
        };
        int count = queryRunner.update(sql,params);
        return count==1;
    }

    @Override
    public boolean UpdataGood(Goods goods)throws SQLException {
        String sql = "update goods set GoodName=?,GoodPrice=?,GoodDescribe=?,GoodStatus=?,GoodType=? where GoodID=?";
        Object[] params={
                goods.getGoodName(),
                goods.getGoodPrice(),
                goods.getGoodDescribe(),
                goods.getGoodStatus(),
                goods.getGoodType(),
                goods.getGoodID()
        };
        int count = queryRunner.update(sql,params);
        return count==1;
    }

    @Override
    public boolean DeleteGoodByID(int id)throws SQLException {
        String sql = "delete from goods where GoodID=?";
        int count = queryRunner.update(sql,id);
        return count==1;
    }

    @Override
    public boolean DeleteGoodByName(String name)throws SQLException {
        String sql = "delete from goods where GoodName =?";
        int count = queryRunner.update(sql,name);
        return count==1;
    }
}
