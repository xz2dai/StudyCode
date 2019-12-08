package com.xz2dai;

public class MyRunnable implements Runnable {
    String name;
    MyRunnable(String input){
        this.name = input;
    }
    @Override
    public void run() {
        System.out.println(name+"汪汪叫");
    }
}
