package com.xz2dai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Connect  {

    Socket sc;
    BufferedWriter dout;
    BufferedReader din;
    JSONObject job;


    /**
     * 网络连接方法
     * 构造函数
     * @param ip 服务器ip地址
     * @param port 连接端口
     */
    public Connect(String ip,int port){
        try {
            sc = new Socket(ip,port);
            din = new BufferedReader(new InputStreamReader(sc.getInputStream(), StandardCharsets.UTF_8));
            dout = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从服务器获取信息
     */
    public void search(String type,Object source){
        switch (type){
            case "login":   //登陆
                job = (JSONObject) JSON.toJSON(source);
                job.put("login","1");
                job.put("type","search");
                try {
                    dout.write(job.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "newMessage":  //新闻信息查询
                break;
            case "PersonMessage":   //个人信息查询
                break;
            case "creditScore": //信誉积分查询
                break;
            case "stall":   //个人车位查询
                break;
            case "help":    //帮助查询
                break;
            default:
                break;
        }
    }


    /**
     * 更新服务端数据
     */
    public void update(String type,Object source){
        switch (type){
            case "personMessage":   //修改个人信息
                break;
            case "ediget":  //注册账号
                break;
            case "updataPassword":  //修改密码
                break;
            case "upHeadPortrait":  //修改头像
                break;
            case "publishStall":    //停车位信息插入
                break;
            default:
                break;
        }

    }

}
