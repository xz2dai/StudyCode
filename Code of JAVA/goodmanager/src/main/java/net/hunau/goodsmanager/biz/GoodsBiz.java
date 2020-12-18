package net.hunau.goodsmanager.biz;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.dao.GoodsDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现商品搜索与添加逻辑
 * author：yq
 * date：11-5
 */
public class GoodsBiz {
    private GoodsDAO goodsDAO = null;
    public GoodsBiz(){
        goodsDAO = new GoodsDAO();
    }

    /**
     * 添加商品
     * @param Goods
     * @return
     */
    public boolean addGoods(Goods Goods){
        return goodsDAO.addGoods(Goods);
    }

    /**
     * 寻找商品
     * condition中的goodsname与goodsid都有可能为空
     * @param condition
     * @return 商品列表
     */
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
