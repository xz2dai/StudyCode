package com.xz2dai;

import java.awt.*;

public class BubbleSort extends Thread {

    private int[] arry;
    long startTime,costTime;

    BubbleSort(int[] arry){
        this.arry = arry.clone();
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        sort();
        costTime = System.currentTimeMillis() - startTime;
        display();
    }

    private void sort(){
        int cup;
        for (int i =0 ;i<=arry.length;i++){
            for(int j = 0;j<=arry.length-i;j++){
                if(arry[i] > arry[j]){
                    cup = arry[i];
                    arry[i] = arry[j];
                    arry[j] = cup;
                }
            }
        }

    }

    public void display(){
        System.out.println("冒泡排序后数组为");
        for (int i = 0;i<=arry.length;i++){
            System.out.print(arry[i]+" ");
        }
        System.out.println();
        System.out.println("所花费时间为："+costTime);
    }

}
