package com.xz2dai;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyRunnable my = new MyRunnable("张昆熠");
        Thread td = new Thread(my);
        td.start();
    }
}
