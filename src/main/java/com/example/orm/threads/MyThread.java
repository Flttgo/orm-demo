package com.example.orm.threads;

public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            if (isInterrupted()) {

            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("开启异步线程");
    }
}
