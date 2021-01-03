package com.troyliu.maliu.concurrency;

import com.troyliu.maliu.annotation.NotThreadSafe;

@NotThreadSafe
public class LazyInitClass {

    private static LazyInitClass instance ;
    public static LazyInitClass getInstance() {
        if(instance == null)
            instance = new LazyInitClass() ;

        return instance ;
    }

}
