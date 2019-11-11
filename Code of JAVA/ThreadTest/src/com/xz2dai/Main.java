package com.xz2dai;

import java.util.Arrays;
import java.util.Random;

public class Main {



    public static void main(String[] args) {
        ArrayManager arrayManager = new ArrayManager();
        arrayManager.BeginTest();
    }


}

class ArrayManager{

    private final int MAX = 10;     //最大数组长度

    private int[] arry;

    Random random;
    QuickSort qs;
    BubbleSort bs;

    public ArrayManager(){
        random = new Random();
        BornArray(arry);

    }

    public void BeginTest(){                    //开始线程
        System.out.println("排序前数组为:");
        for (int i = 0;i<=arry.length;i++){
            System.out.print(arry[i]+" ");
        }
        System.out.println();
        bs = new BubbleSort(arry);
        bs.start();
        qs = new QuickSort(arry);
        Thread qsThread = new Thread(qs);
    }

    public int[] BornArray(int[] arry){         //随机生成数组
        arry = new int[MAX];
        for(int i =0 ;i<=MAX;i++){
            random.nextInt(MAX);
        }
        return arry;
    }
}
