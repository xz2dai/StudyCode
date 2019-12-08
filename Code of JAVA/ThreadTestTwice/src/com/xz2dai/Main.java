package com.xz2dai;

import java.util.Random;

public class Main {



    public static void main(String[] args) {
        ArrayManager arrayManager = new ArrayManager();
        arrayManager.BeginTest();
    }


}

class ArrayManager{

    private static int MAX = 10;     //最大数组长度

    private int[] arry = new int[MAX];

    Random random;


    public ArrayManager(){
        BornArray();

    }

    public void BeginTest(){                    //开始线程
        System.out.println("排序前数组为:");
        showArray();
        System.out.println();
        BubbleSort bs = new BubbleSort(arry);
        bs.start();
        QuickSort qs = new QuickSort(arry);
        Thread qsThread = new Thread(qs);
        qsThread.start();
    }

    public void BornArray(){         //随机生成数组
        random = new Random();
        for(int i =0 ;i<MAX;i++){
            arry[i] = random.nextInt(MAX);
        }
    }

    public void showArray(){
        for(int i =0;i<MAX;i++){
            System.out.print(arry[i] + " ");
        }
    }
}
