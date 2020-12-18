package net.hunau.goodsmanager.dao;

import net.hunau.goodsmanager.bean.Goods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品数据处理类
 * author：yq
 *  * date：11-5
 */
public class GoodsDAO extends baseDAO {
    /**
     * 添加商品
     * @param goods goodsbean
     * @return 布尔值的插入执行结果
     */
    public boolean addGoods(Goods goods){
        String sql = "insert into goods(goodsName, goodsPrice, goodsCount, goodsDep, goodsType) values (?,?,?,?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,goods.getGoodname());      //从bean中提取并设置参数
            pstm.setDouble(2,goods.getGoodprice());
            pstm.setInt(3,goods.getGoodcount());
            pstm.setString(4,goods.getGoodDep());
            pstm.setInt(5,goods.getGoodtype());
            //获取执行结果
            int result = pstm.executeUpdate();
            //根据执行结果返回数据
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取所有商品
     * 可能会产生数据过大内存溢出问题
     * @return 所有商品的列表
     */
    public List<Goods> getGoods(){
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select * from goods";
    try{
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Goods goods = new Goods();
            goods.setId(rs.getInt("goodsID"));
            goods.setGoodname(rs.getString("goodsName"));
            goods.setGoodprice(rs.getDouble("goodsPrice"));
            goods.setGoodcount(rs.getInt("goodsCount"));
            goods.setGoodDep(rs.getString("goodsDep"));
            goods.setGoodtype(rs.getInt("goodsType"));
            goodsList.add(goods);
        }
    }catch(Exception e) {
        e.printStackTrace();
    }
    return goodsList;
    }

    /**
     * 根据商品名字获取商品
     */
    public List<Goods> getGoods(String goodsName) {
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select * from goods where goodsName=?";
        try{
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,goodsName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Goods goods = new Goods();
                goods.setId(rs.getInt("goodsID"));
                goods.setGoodname(rs.getString("goodsName"));
                goods.setGoodprice(rs.getDouble("goodsPrice"));
                goods.setGoodcount(rs.getInt("goodsCount"));
                goods.setGoodDep(rs.getString("goodsDep"));
                goods.setGoodtype(rs.getInt("goodsType"));
                goodsList.add(goods);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    /**
     * 根据商品id获取商品
     */
    public Goods getGoods(int id) {
        Goods goods = null;
        String sql = "select * from goods where goodsID=?";
        try{
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                goods = new Goods();
                goods.setId(rs.getInt("goodsID"));
                goods.setGoodname(rs.getString("goodsName"));
                goods.setGoodprice(rs.getDouble("goodsPrice"));
                goods.setGoodcount(rs.getInt("goodsCount"));
                goods.setGoodDep(rs.getString("goodsDep"));
                goods.setGoodtype(rs.getInt("goodsType"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    /**
     * 根据商品id删除商品
     * @param id
     * @return
     */
    public boolean delGoods(int id) {
        String sql = "delete from goods where goodsID=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            int result = pstm.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新商品信息
     * 更新依据为goodsbean中的goodsid
     */
    public boolean updateGoods(Goods Goods) {
        String sql = "update goods set goodsName=?,goodsPrice=?,goodsCount=?,goodsDep=?,goodsType=? where goodsID=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, Goods.getGoodname());
            pstm.setDouble(2,Goods.getGoodprice());
            pstm.setInt(3,Goods.getGoodcount());
            pstm.setString(4,Goods.getGoodDep());
            pstm.setInt(5,Goods.getGoodtype());
            pstm.setInt(6,Goods.getId());
            int result = pstm.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
