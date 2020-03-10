package com.company;

import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) {

        int count = 0;

        try{
            ServerSocket server = new ServerSocket(2333);
            System.out.println("开始对端口2333进行监听");

            VisualCilent vc = new VisualCilent();

            while(true){
                Socket sc = server.accept();

                DataInputStream din=new DataInputStream(sc.getInputStream());

                DataOutputStream dout=new DataOutputStream(sc.getOutputStream());

                vc.run();

                System.out.println("客户端ip地址是："+sc.getInetAddress());
                System.out.println("客户端端口号是："+sc.getPort());
                System.out.println("本地端口号是："+sc.getLocalPort());
                System.out.println("服务端：接收到消息\""+din.readUTF()+"\"");

                dout.writeUTF("服务端：消息已收到！");

                din.close();
                dout.close();
                sc.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
