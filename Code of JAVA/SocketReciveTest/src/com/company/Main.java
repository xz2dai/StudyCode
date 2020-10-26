package com.company;


import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args)  {

        int count = 0;  //接入计数
        int port = 2333;    //端口
        Socket sc;   //socket对象

        /*

        try{

            TestPack tp = null;
            String inf = null;
            ServerSocket server = new ServerSocket(port);       //服务端用于接入的socket
            System.out.println("start listening port "+port);

            while(true){    //不断监听端口有无连接
                sc = server.accept();   //如果ServerSocket监听到连接则生成一个socket对象

                DataInputStream din=new DataInputStream(sc.getInputStream());       //获取输入流

                DataOutputStream dout=new DataOutputStream(sc.getOutputStream());   //获取输出流


                System.out.println("客户端ip地址是："+sc.getInetAddress());
                System.out.println("客户端端口号是："+sc.getPort());
                System.out.println("本地端口号是："+sc.getLocalPort());

                inf = din.readUTF();    //从输入流中获取消息



                if(din!= null) {
                    dout.writeUTF("服务端已接受到信息");     //输出流输出信息
                    dout.flush();   //输出信息后必须刷新以发出消息
                    System.out.println("服务端接收到信息："+inf);
                    //tp = JSON.parseObject(inf, TestPack.class);   //将收到的jsonstring转换为javabean
                    //System.out.println("信息已解码：");
                    //System.out.println("ID:"+tp.getId());
                    //System.out.println("内容:"+tp.getInformation());
                }else{
                    dout.writeUTF("null message！");     //收到空消息则返回给服务端null警告
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
        while (true){   //不断监听
            try {
                if (server != null) {
                    sc = server.accept();   //监听到连接就创建一个socket对象
                    System.out.println("socket connect successful");
                    ConnectThread ct = new ConnectThread(sc);   //开启一个连接线程
                    System.out.println("creat connectthread successful");
                    ct.start();   //启动线程
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            }

    }
}
