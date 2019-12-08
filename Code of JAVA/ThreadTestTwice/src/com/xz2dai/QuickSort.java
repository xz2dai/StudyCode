package com.xz2dai;

public class QuickSort implements Runnable {

    private int[] arry;
    long startTime,costTime;

    QuickSort(int[] arry){
        this.arry = arry.clone();
    }

    @Override
    public void run() {
        System.out.println("快速排序开始");
        startTime = System.currentTimeMillis();
        sort();
        costTime = System.currentTimeMillis() - startTime;
        display();
    }

    private void sort(){
        qs(0,arry.length-1);
    }

    public void display(){
        System.out.println("快速排序后数组为");
        for (int i = 0;i<arry.length;i++){
            System.out.print(arry[i]+" ");
        }
        System.out.println();
        System.out.println("所花费时间为："+costTime);
    }

    public void qs(int min,int max){            //快排核心函数
        if(min == max ) return;
        int key = arry[min];
        int i = min,j =max;
        int cup;            //数字交换的中间变量
        while(i != j){
            while(arry[i]<=key && i<j) i++;
            while(arry[j]>=key && i<j) j--;
            if(i<j){
                cup = arry[i];
                arry[i] = arry[j];
                arry[j] = cup;
            }
        }
        arry[min] = arry[i];
        arry[i] = key;
        qs(min,i-1);
        qs(i+1,max);
    }
}
