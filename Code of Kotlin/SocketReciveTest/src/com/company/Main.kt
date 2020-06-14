package com.company

import com.company.bean.TestPack
import java.io.*
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Executors

object Main {
    //线程池
    val mainthreadpoll = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 3 + 2)

    @JvmStatic
    fun main(args: Array<String>) {
        val count = 0
        val port = 8080
        var sc: Socket? = null




        try{

            var tp: TestPack? = null
            var inf: String? = null
            val server:ServerSocket = ServerSocket(port)
            System.out.println("start listening port "+port);

            while(true){
                sc = server.accept();

                System.out.println("客户端ip地址是："+sc.getInetAddress());
                System.out.println("客户端端口号是："+sc.getPort());
                System.out.println("本地端口号是："+sc.getLocalPort());

                mainthreadpoll.execute(ConnectThread(sc));

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