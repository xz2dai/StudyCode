package com.xz2dai;

import com.xz2dai.bean.Login;
import com.xz2dai.bean.UserOrdinary;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Main {

    //public final static String ip = "101.133.235.230";
    public final static String ip = "127.0.0.1";
    public final static int port = 8080;
//    private static String ip = "120.79.87.21";
//    private static int portUpload = 5423;
//    private static int port = 5422;

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

        /*
        Login tp = new Login();
        tp.setName("123");
        tp.setPassWord("123");

         */

//        String me = "{\"name\":\"123\",\"type\":\"search\",\"upHeadPortrait\":\"2\"}\n";
        String me = "2333";


//        Connect ct = Connect.getConncet();
//        ct.sendMessage(me);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String rec = "";
//        rec = ct.receiveMessage();
//        System.out.println(rec);

        Socket sc = new Socket(ip,port);

        OutputStreamWriter output = new OutputStreamWriter(sc.getOutputStream());
        InputStreamReader input = new InputStreamReader(sc.getInputStream());

        output.write(me);
        output.flush();
        System.out.println("msg send");

        char[] buffermsg = new char[1000];
        int length = input.read(buffermsg);
        if(length>-1){
            String msg = new String(buffermsg,0,length);
            System.out.println(msg);
        }else{
            System.out.println("null");
        }

        /*
        UserOrdinary uo = new UserOrdinary();
        uo  = (UserOrdinary) ct.disposeOperation(rec);
        if(uo!=null){
            System.out.println("UserID:"+uo.getIdNum());
            System.out.println("User PassWord:"+uo.getPassword());
        }
                */


    }
}
