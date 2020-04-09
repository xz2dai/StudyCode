package com.xz2dai;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    private static String ip = "120.79.87.21";
    private static int port = 5423;
    private static int portUpload = 5422;

    String TAG = "Main";

    public static String ReadLine(){
        String mLine = null;
        InputStreamReader IS = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(IS);
        try{
            mLine = BR.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        mLine = mLine.substring(0,1).toUpperCase() + mLine.substring(1);
        return mLine;
    }

    public static void WriteFile(String msg) throws IOException {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File home = fsv.getHomeDirectory();
        String HomePath = home.getPath();               //获取电脑桌面路径
        File file = new File(HomePath+"\\IOTest.txt");
        file.createNewFile();
        FileWriter FW = new FileWriter(file);
        BufferedWriter BW = new BufferedWriter(FW);
        BW.write(msg+"\r\n");
        BW.flush();
        BW.close();
    }

    public static void connect() {
        try {
            System.out.println("start connect");
            Socket socket1 = new Socket(ip,port);
            System.out.println("connect successful");
            OutputStream out1 = socket1.getOutputStream();
            String me = "{\"type\":\"search\",\"name\":\"123\",\"passWord\":\"123\",\"login\":\"1\"}\n";
            byte[] message = me.getBytes();
            out1.write(message);
            out1.flush();
            System.out.println("send message successful");
            InputStreamReader in = new InputStreamReader(socket1.getInputStream());
            char[] inMessage = new char[1024];
            System.out.println("start receive reply");
            int a =in.read(inMessage);
            String str = inMessage.toString();
            System.out.println(new String(inMessage,0,a));
            in.close();
            socket1.close();
            /**
             * 此处写一个图片的传输的实例
             * 用于测试后台ImageIO的读入
             * 图片传输用到另一个端口5423
             *
             */
//			socket = new Socket(ip,port);
//			out = socket.getOutputStream();
//			BufferedImage image = ImageIO.read(SocketServerTest.class.getResource("/com/feilonkji/socketservertest/1.jpg"));
//			ImageIO.write(image, "JPG", out);
//			out.flush();
//			socket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
	// write your code here
        connect();
    }
}
