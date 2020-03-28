package com.xz2dai;

public class Main {

    public static void main(String[] args) {

        MyThread mt = new MyThread(2);
        mt.run();
    }
}

class MyThread extends Thread{

    int j;

    public MyThread(int i){
        this.j = i;
        System.out.println("线程初始化成功");
    }

    public void run(){
        System.out.println("线程启动");
        for(int i=j;i<=10;i++){
            System.out.println(i);
        }
    }
}
