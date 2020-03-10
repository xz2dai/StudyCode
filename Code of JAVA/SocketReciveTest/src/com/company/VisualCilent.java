package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class VisualCilent {
    public void run(){
        try{
            Socket sc = new Socket(InetAddress.getLocalHost(),2333);

            DataInputStream din = new DataInputStream(sc.getInputStream());

            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());

            dout.writeUTF("hao");

            System.out.println("客户端："+din.readUTF());

            close(din,dout,sc);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void close(DataInputStream din,DataOutputStream dout,Socket sc){
        try {
            din.close();

            dout.close();

            sc.close();

            }catch (IOException e){
            e.printStackTrace();
        }
    }

}
