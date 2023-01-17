package com.example.orm.threads;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("开启异步线程2");
    }
}
