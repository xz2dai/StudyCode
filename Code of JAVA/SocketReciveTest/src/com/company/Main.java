package com.company;

import com.alibaba.fastjson.JSON;
import com.company.bean.TestPack;

import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args)  {

        int count = 0;
        int port = 5423;
        Socket sc = null;

        /*

        try{

            TestPack tp = null;
            String inf = null;
            ServerSocket server = new ServerSocket(port);
            System.out.println("start listening port "+port);

            while(true){
                sc = server.accept();

                DataInputStream din=new DataInputStream(sc.getInputStream());

                DataOutputStream dout=new DataOutputStream(sc.getOutputStream());


                System.out.println("客户端ip地址是："+sc.getInetAddress());
                System.out.println("客户端端口号是："+sc.getPort());
                System.out.println("本地端口号是："+sc.getLocalPort());

                inf = din.readUTF();



                if(din!= null) {
                    dout.writeUTF("服务端已接受到信息");
                    dout.flush();
                    System.out.println("服务端接收到信息："+inf);
                    //tp = JSON.parseObject(inf, TestPack.class);
                    //System.out.println("信息已解码：");
                    //System.out.println("ID:"+tp.getId());
                    //System.out.println("内容:"+tp.getInformation());
                }else{
                    dout.writeUTF("null message！");
                }

                din.close();
                dout.close();
                sc.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


         */


        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                if (server != null) {
                    sc = server.accept();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("socket connect successful");
                ConnectThread ct = new ConnectThread(sc);
                System.out.println("creat connectthread successful");
                ct.run();
            }

    }
}
