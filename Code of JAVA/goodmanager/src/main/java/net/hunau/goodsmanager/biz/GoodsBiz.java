package net.hunau.goodsmanager.biz;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.dao.GoodsDAO;

import java.util.ArrayList;
import java.util.List;

public class GoodsBiz {
    private GoodsDAO goodsDAO = null;
    public GoodsBiz(){
        goodsDAO = new GoodsDAO();
    }
    public boolean addGoods(Goods Goods){
        return goodsDAO.addGoods(Goods);
    }
    public List<Goods> findGoods(Goods condition) {
        List<Goods> goodsList = new ArrayList<>();
        if(condition.getId() != 0){
            goodsList.add(goodsDAO.getGoods(condition.getId()));
        }
        if(condition.getGoodname() != null){
            goodsList.addAll(goodsDAO.getGoods(condition.getGoodname()));
        }
        return goodsList;
    }

}
