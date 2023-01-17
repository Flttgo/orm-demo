package com.example.orm.services;

import org.apache.ibatis.cache.decorators.BlockingCache;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) throws InterruptedException {
//        if  (lock.tryLock(3, TimeUnit.SECONDS)) {
//
//        }
        lock.lock();
        try {
            count += n;
//                Thread.sleep(10000);
        } finally {
//                lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    public void add() {

    }
}
