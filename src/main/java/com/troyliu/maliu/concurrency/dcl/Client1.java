package com.troyliu.maliu.concurrency.dcl;

import com.troyliu.maliu.annotation.NotThreadSafe;

/**
 * code 1.2 代码
 *
 * @author TroyLiu
 * @version 1.0
 * @date 2021/3/28 18:22
 */
@NotThreadSafe
public class Client1 {

    private LazyInitClass instance ;

    public synchronized LazyInitClass getInstance() {
        if(instance == null)
            instance = new LazyInitClass("LazyInitClassFieldName") ;

        return instance ;
    }

}
