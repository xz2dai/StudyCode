package com.xz2dai;

/*
    计算机操作系统课程：实现线程的同步与互斥-生产者与消费者问题
     */
public class Main {
    final static public int k=8;

    public static void main(String[] args) {
	// write your code here
        porblem1 p1 = new porblem1();
        p1.run();
    }
}
