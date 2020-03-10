package com.company;

import com.alibaba.fastjson.JSON;
import com.company.bean.TestPack;

import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        String inf,deinf;

        try{
            ServerSocket server = new ServerSocket(2333);
            TestPack tp = null;
            System.out.println("开始对端口2333进行监听");

            while(true){
                Socket sc = server.accept();

                DataInputStream din=new DataInputStream(sc.getInputStream());

                DataOutputStream dout=new DataOutputStream(sc.getOutputStream());


                System.out.println("客户端ip地址是："+sc.getInetAddress());
                System.out.println("客户端端口号是："+sc.getPort());
                System.out.println("本地端口号是："+sc.getLocalPort());

                inf = din.readUTF();



                if(din!= null) {
                    System.out.println("服务端接收到信息："+inf);
                    tp = JSON.parseObject(inf, TestPack.class);
                    System.out.println("信息已解码：");
                    System.out.println("ID:"+tp.getId());
                    System.out.println("内容:"+tp.getInformation());
                }else{
                    System.out.println("客户端发出信息为空！");
                }

                din.close();
                dout.close();
                sc.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
