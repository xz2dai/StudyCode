package com.xz2dai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xz2dai.bean.TestPack;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        //Socket sc = new Socket("101.133.235.230",2333);
         Socket sc = new Socket(InetAddress.getLocalHost(),2333);


        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));

        DataOutputStream dout = new DataOutputStream(sc.getOutputStream());

         */

        BufferedReader din = new BufferedReader(new InputStreamReader(sc.getInputStream(), StandardCharsets.UTF_8));
        BufferedWriter dout = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream(), StandardCharsets.UTF_8));

        TestPack testpack = new TestPack();
        testpack.setId(10086);
        testpack.setInformation("hao!");

        JSONObject job = (JSONObject)JSON.toJSON(testpack);
        job.put("type","search");
        job.put("login","1");
        String jstr = JSONObject.toJSONString(job);

        System.out.println("send message...");
        dout.write(jstr+"\n");
        dout.flush();
        System.out.println("send message successful");

        System.out.println("客户端："+din.readLine());
        System.out.println("客户端："+din.readLine());

        din.close();
        dout.close();
        sc.close();


    }
}
