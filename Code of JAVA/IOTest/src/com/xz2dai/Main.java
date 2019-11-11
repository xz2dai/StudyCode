package com.xz2dai;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class Main {

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

    public static void main(String[] args) {
	// write your code here
        try {
            WriteFile(ReadLine());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
