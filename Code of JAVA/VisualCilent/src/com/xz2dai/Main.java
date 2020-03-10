package com.xz2dai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xz2dai.bean.TestPack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            Socket sc = new Socket(InetAddress.getLocalHost(),2333);

            DataInputStream din = new DataInputStream(sc.getInputStream());

            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());

            TestPack testpack = new TestPack();
            testpack.setId(10086);
            testpack.setInformation("hao!");

            String jsonstr = JSON.toJSONString(testpack);

            dout.writeUTF(jsonstr);

            System.out.println("客户端："+din.readUTF());

            din.close();
            dout.close();
            sc.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
