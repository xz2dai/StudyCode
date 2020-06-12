package com.company

import com.company.bean.TestPack
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Executors

object Main {
    //线程池
    val mainthreadpoll = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 3 + 2)

    @JvmStatic
    fun main(args: Array<String>) {
        val count = 0
        val port = 2333
        var sc: Socket? = null




        try{

            var tp: TestPack? = null
            var inf: String? = null
            val server:ServerSocket = ServerSocket(port)
            System.out.println("start listening port "+port);

            while(true){
                sc = server.accept();

                val din:DataInputStream = DataInputStream(sc.getInputStream())

                val dout:DataOutputStream = DataOutputStream(sc.getOutputStream())


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
        }catch (e:Exception){
            e.printStackTrace();
        }





//        var server: ServerSocket? = null
//        try {
//            server = ServerSocket(port)
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//        while (true) {
//            try {
//                if (server != null) {
//                    sc = server.accept()
//                    mainthreadpoll.execute(ConnectThread(sc!!))
//                }
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//
//        }
    }
}