package com.troyliu.maliu.concurrency.dcl;

import com.troyliu.maliu.annotation.ThreadSafe;

/**
 * code 3.2 代码
 * @author TroyLiu
 * @version 1.0
 * @date 2021/3/28 18:25
 */
@ThreadSafe
public class Client4 {

    private volatile LazyInitClass instance ;

    public LazyInitClass getInstance() {
        if(instance == null){
            synchronized(this){
                if(instance == null){
                    instance = new LazyInitClass("LazyInitClassFieldName") ;
                }
            }
        }
        return instance ;
    }

}
