package com.c611.classProject.service.impl;

import com.c611.classProject.bean.Goods;
import com.c611.classProject.bean.GoodsPageBean;
import com.c611.classProject.dao.IGoodsDao;
import com.c611.classProject.dao.impl.GoodsDaoImpl;
import com.c611.classProject.service.IGoodsService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/21 12:49
 */
public class GoodsServiceImpl implements IGoodsService {
    IGoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public Goods findGoodByID(int id) throws SQLException {
        return goodsDao.findGoodByID(id);
    }

    @Override
    public Goods findGoodByName(String name)throws SQLException {
        return goodsDao.findGoodByName(name);
    }

    @Override
    public List<Goods> findGoodsList() throws SQLException {
        return goodsDao.findGoodsList();
    }

    @Override
    public boolean AddGood(Goods goods) throws SQLException{
        return goodsDao.AddGood(goods);
    }

    @Override
    public boolean UpdataGood(Goods goods) throws SQLException{
        return goodsDao.UpdataGood(goods);
    }

    @Override
    public boolean DeleteGoodByID(int id) throws SQLException{
        return goodsDao.DeleteGoodByID(id);
    }

    @Override
    public boolean DeleteGoodByName(String name) throws SQLException{
        return goodsDao.DeleteGoodByName(name);
    }

    @Override
    public GoodsPageBean getGoodsPageBean(int page, int size) throws SQLException {
        GoodsPageBean goodsPageBean = new GoodsPageBean();
        page = Math.max(page, 1);
        size = Math.max(size,1);

        List<Goods> goodsList = goodsDao.findGoodsList((page-1)*size,size);

        int count = goodsDao.GetGoodsCount();
        int totalPage = count/size;
        if(count%size !=0) totalPage++;


        goodsPageBean.setGoodsList(goodsList);
        goodsPageBean.setTotalPageCount(totalPage);
        goodsPageBean.setCurrentPage(page);
        goodsPageBean.setSize(size);
        goodsPageBean.setTotalCount(count);

        return goodsPageBean;
    }
}
