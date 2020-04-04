package com.xz2dai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xz2dai.bean.TestPack;
import com.xz2dai.bean.UserOrdinary;

import java.io.*;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        //Socket sc = new Socket("101.133.235.230",2333);
        //Socket sc = new Socket(InetAddress.getLocalHost(),2333);


        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));

        DataOutputStream dout = new DataOutputStream(sc.getOutputStream());

         */

        /*
        //初始化
        BufferedReader din = new BufferedReader(new InputStreamReader(sc.getInputStream(), StandardCharsets.UTF_8));
        BufferedWriter dout = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream(), StandardCharsets.UTF_8));
        //创建信息
        TestPack testpack = new TestPack();
        testpack.setId(10086);
        testpack.setInformation("hao!");
        //包装信息
        JSONObject job = (JSONObject)JSON.toJSON(testpack);
        job.put("type","search");
        job.put("login","1");
        String jstr = JSONObject.toJSONString(job);
        //发送信息
        System.out.println("send message...");
        dout.write(jstr+"\n");
        dout.flush();
        System.out.println("send message successful");
        //收取回复信息
        System.out.println("客户端："+din.readLine());
        System.out.println("客户端："+din.readLine());
        //关闭连接
        din.close();
        dout.close();
        sc.close();
        */


        UserOrdinary tp = new UserOrdinary();
        tp.setId(10086);
        tp.setPassword("qwer10086");

        Connect ct = new Connect("127.0.0.1",2333);
        ct.sendMessage(ct.search("login",tp));
        String rec = "";
        rec = ct.receiveMessage();
        System.out.println("received server message:"+rec);
        tp = (UserOrdinary)ct.disposeOperation(rec);
        System.out.println("UserID:"+tp.getId());
        System.out.println("PassWord:"+tp.getPassword());
        System.out.println("AccountNum:"+tp.getAccountNum());
        ct.close();

    }
}
