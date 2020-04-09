package com.xz2dai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xz2dai.bean.UserOrdinary;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Connect  {

    Socket sc = null;
    OutputStreamWriter dout = null;
    InputStreamReader din = null;
    JSONObject jsonData = null;

    String replyMessage = "";

    /**
     * 网络连接方法
     * 构造函数
     * @param ip 服务器ip地址
     * @param port 连接端口
     */
    public Connect(String ip,int port){

        try {
            sc = new Socket(ip,port);
            if(sc != null){
                System.out.println("connect server successful");
            }else{
                System.out.println("connect server failed");
            }
            din = new InputStreamReader(sc.getInputStream(), StandardCharsets.UTF_8);
            dout = new OutputStreamWriter(sc.getOutputStream(), StandardCharsets.UTF_8);
            //replyMessage = din.readLine();
            //System.out.println("server connect reply message:"+replyMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送数据至服务器
     * @param message 要发送至服务器的字符串
      */
    public void sendMessage(String message){
        try {
            if(dout != null || message != null){
                //message = message+"\n";
                message = "{\"login\":\"1\",\"name\":\"123\",\"passWord\":\"123\",\"type\":\"search\"}\n";
                //byte[] WaitToSendMsg = message.getBytes();
                dout.write(message);
                dout.flush();
            }

            System.out.println("send message successful");
        } catch (IOException e) {
            System.out.println("向服务端发送数据时出错");
            e.printStackTrace();
        }
    }

    public String receiveMessage(){
        char[] message = new char[1024];
        String message_t = "";
        try {
            System.out.println("开始接受服务器消息");
            int a = din.read(message);
            message_t = Arrays.toString(message);
            System.out.println("get message:"+message_t);
        } catch (IOException e) {
            System.out.println("接受消息失败");
            e.printStackTrace();
        }
        return message_t;
    }

    //获取服务器返回数据操作类型
    //4.4：这段代码完全由服务端代码复制而来，需要修改
    public String getDisposeType(String message)  {
        String type = "";
        if(message == null || message.equals("")){
            return "null";
        }else{
            jsonData = JSON.parseObject(message);
            type = String.valueOf(jsonData.get("type"));
        }
        return type;
    }

    //根据服务端返回数据操作类型进行具体操作
    //4.4：这段代码完全由服务端代码复制而来，需要修改
    public Object disposeOperation(String message) {
        if(message == null || message.equals("")){
            System.out.println("message is empty!");
            return null;
        }
        String type = getDisposeType(message);
        JSONObject jdata = null;
        Object bufferpack = null;
        System.out.println("type:"+type);
        if(type != null) {
            switch (type) {
                case "search":{
                    /*
                     * 查询操作
                     * 进行判断查询类型
                     * 根据json数据中的其他数据进行查询
                     */
                    //判断登陆操作
                    if(jsonData.get("login") != null) {
                        //调用登陆验证方法
                        jdata = JSONObject.parseObject(message);
                        bufferpack = JSON.toJavaObject(jdata,UserOrdinary.class);
                    }
                    //查询信息新闻显示
                    if(jsonData.get("newMessage") != null) {
                        //调用新闻信息查询
                    }
                    //查询个人信息
                    if(jsonData.get("personMessage") != null) {
                        //调用个人信息查询
                    }
                    //信誉积分
                    if(jsonData.get("creditScore") != null) {
                        //调用信誉积分查询
                    }
                    //个人车位查询
                    if(jsonData.get("stall") != null) {
                        //调用个人车位信息查询
                    }
                    //帮助页面查询
                    if(jsonData.get("help") != null) {
                        //调用帮助查询
                    }
                    break;
                }
                case "updata":{
                    /**
                     * 修改数据操作
                     * 根据json数据中的其他数据进行修改
                     */
                    //修改个人信息
                    if(jsonData.get("personMessage") != null) {
                        //调用修改个人信息的方法
                    }
                    //注册账号
                    if(jsonData.get("ediget") != null) {
                        //调用注册账号
                    }
                    //修改密码
                    if(jsonData.get("updataPassWord") != null) {
                        //调用修改密码
                    }
                    //修改头像
                    if(jsonData.get("upHeadPortrait") != null) {
                        //调用修改头像
                    }
                    //发布停车位
                    if(jsonData.get("publishStall") != null) {
                        //调用停车位信息插入方法
                    }
                    break;
                }
                default:{
                    break;
                }
            }
        }
        return bufferpack;
    }

    /**
     * 包装search操作类型json数据
     * @param type 操作类型
     * @param source 包含信息的javabean
     * @return 返回source转换的json格式的字符串
     */
    public String search(String type,Object source){
        JSONObject job = null;
        String jstr = null;
        System.out.println("开始查找编码操作类型");
        switch (type){
            case "login":   //登陆
                System.out.println("开始编码login内容");
                job = (JSONObject) JSON.toJSON(source);
                job.put("login","1");
                job.put("type","search");
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
        if (job != null) {
            jstr = job.toJSONString();
            System.out.println("编码成功，编码结果为："+jstr);
        }else {
            System.out.println("编码失败，jsonobject为空");
        }
        return jstr;
    }



    /**
     * 包装update操作类型json数据
     * 参数用法同search方法
     */
    public String update(String type,Object source){
        JSONObject job = null;
        String jstr = null;
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
        if (job != null) {
            jstr= job.toJSONString();
        }
        return jstr;
    }

    /**
     * 关闭连接
     */
    public void close(){
        try {
            if(din != null){
                din.close();
            }
            if(dout != null){
                dout.close();
            }
            if(sc != null) {
                sc.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("关闭连接");
    }
}
