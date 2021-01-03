package com.troyliu.maliu.component;

import java.util.concurrent.CountDownLatch;

public abstract class Worker implements Runnable {

    private CountDownLatch countDownLatch ;

    public Worker() {
    }

    public Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch ;
    }

    public final void run() {
        try {
            runBy() ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown(); ;
            }
        }
    }

    public abstract void runBy() ;
}
