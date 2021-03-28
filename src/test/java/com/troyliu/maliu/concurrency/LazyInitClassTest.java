package com.troyliu.maliu.concurrency;

import com.troyliu.maliu.component.Worker;
import com.troyliu.maliu.concurrency.dcl.Client;
import com.troyliu.maliu.concurrency.dcl.LazyInitClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class LazyInitClassTest {

    private Client client ;

    @Before
    public void setup() {
        client = new Client() ;
    }

    @Test
    public void testGetInstance() {
        CountDownLatch countDownLatch = new CountDownLatch(2) ;

        final List<LazyInitClass> instances = new ArrayList<>(2) ;

        Runnable r1 = new Worker(countDownLatch){
            @Override
            public void runBy() {
                instances.add(client.getInstance()) ;
            }
        };
        Runnable r2 = new Worker(countDownLatch) {
            @Override
            public void runBy() {
                instances.add(client.getInstance()) ;
            }
        } ;

        Thread t1 = new Thread(r1) ;
        Thread t2 = new Thread(r2) ;
        t1.start() ;
        t2.start() ;

        try {
            countDownLatch.await() ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(instances.get(0), instances.get(1)) ;
    }
}
