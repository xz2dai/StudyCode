package com.xz2dai;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

//实现生产者-消费者问题
public class porblem1 {
    final static public int k= Main.k;  //缓冲区大小

    int nextin = 0,nextout = 0;

    List<Object> buffer = new LinkedList<>();


    Semaphore mutex = new Semaphore(1);            //信号量
    Semaphore empty= new Semaphore(0);
    Semaphore full= new Semaphore(k);     //互斥信号量

    void producer() throws Exception{    //生产者
        while(true){
            //produce an item in nextp
            full.acquire();
            mutex.acquire();
            Thread.sleep(1000);
            buffer.add(new Object());
            nextin = (nextin+1)%k;
            System.out.println("生产者："+Thread.currentThread().getName()+"生产了一个产品,现有产品"+buffer.size()+"个");
            mutex.release();
            empty.release();
        }
    }

    void consumer() throws Exception{    //消费者
        while(true){
            empty.acquire();
            mutex.acquire();
            Thread.sleep(3000);
            buffer.remove(buffer.size()-1);
            nextout = (nextout+1)%k;
            System.out.println("消费者："+Thread.currentThread().getName()+"消费了一个产品,现有产品"+buffer.size()+"个");
            mutex.release();
            full.release();
            //consume the item in nextc
        }
    }

    //记录型信号量
    void wait(Semaphore s){

    }

    void signal(Semaphore s){

    }

    void parbegin(int sizeofp,int sizeofc){
        List<Thread> plist = new LinkedList<>();
        for(int i=0 ;i<sizeofp;i++){
            plist.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            Thread.sleep(1000);
                            producer();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        List<Thread> clist = new LinkedList<>();
        for(int i=0;i<sizeofc;i++){
            clist.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            Thread.sleep(3000);
                            consumer();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        for(Thread i:plist) i.start();
        for(Thread i:clist) i.start();
    }

    void run(){

        parbegin(3,3);
    }
}
