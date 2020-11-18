package net.hunau.goodsmanager.dao;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO extends baseDAO {
    public List<GoodsType> scanAllGoodsType(){
        List<GoodsType> goodsTypeList = new ArrayList<>();
        try {
            String sql = "select * from goodstype";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                GoodsType goodsType = new GoodsType();
                goodsType.setId(rs.getInt("id"));
                goodsType.setTypeName(rs.getString("typename"));
                goodsType.setTypeDec(rs.getString("typedes"));
                goodsTypeList.add(goodsType);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return goodsTypeList;
    }

    public String getTypeDesc(int id){
        String desc = "";
        try {
            String sql = "select * from goodstype where id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                desc = rs.getString("typedes");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return desc;
    }

    public boolean AddType(GoodsType type){
        String sql = "insert into goodstype(id, typename, typedes) values (?,?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,type.getId());
            pstm.setString(2, type.getTypeName());
            pstm.setString(3,type.getTypeDec());

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
