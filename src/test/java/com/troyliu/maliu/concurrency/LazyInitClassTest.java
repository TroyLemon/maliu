package com.troyliu.maliu.concurrency;

import com.troyliu.maliu.component.Worker;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.junit.Assert;
import org.junit.Test;

public class LazyInitClassTest {

    @Test
    public void testGetInstance() {
        CountDownLatch countDownLatch = new CountDownLatch(2) ;

        List<LazyInitClass> instances = new ArrayList<>(2) ;

        Runnable r1 = new Worker(countDownLatch){
            @Override
            public void runBy() {
                instances.add(LazyInitClass.getInstance()) ;
            }
        };
        Runnable r2 = new Worker(countDownLatch) {
            @Override
            public void runBy() {
                instances.add(LazyInitClass.getInstance()) ;
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

/*
    执行多次之后，有几率出现如下异常

java.lang.AssertionError:
Expected :com.troyliu.maliu.concurrency.LazyInitClass@579bb367
Actual   :com.troyliu.maliu.concurrency.LazyInitClass@1de0aca6
<Click to see difference>
	at org.junit.Assert.fail(Assert.java:93)
	at org.junit.Assert.failNotEquals(Assert.java:647)
	at org.junit.Assert.assertEquals(Assert.java:128)
	at org.junit.Assert.assertEquals(Assert.java:147)
	at com.troyliu.maliu.concurrency.LazyInitClassTest.testGetInstance(LazyInitClassTest.java:41)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:300)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:157)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)

*/


}
