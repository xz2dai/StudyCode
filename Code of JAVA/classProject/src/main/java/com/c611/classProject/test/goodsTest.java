package com.c611.classProject.test;

import com.c611.classProject.bean.Goods;
import com.c611.classProject.service.impl.GoodsServiceImpl;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/21 13:17
 */
public class goodsTest {
    @Test
    public void test1(){
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        try {
            Goods goods = goodsService.findGoodByID(1);
            System.out.println(goods.getGoodName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
