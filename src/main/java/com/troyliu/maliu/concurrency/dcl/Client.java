package com.troyliu.maliu.concurrency.dcl;

import com.troyliu.maliu.annotation.ThreadSafe;

/**
 * code 1.1 代码
 *
 * @author TroyLiu
 * @version 1.0
 * @date 2021/3/28 18:22
 */
@ThreadSafe
public class Client {

    private LazyInitClass instance ;

    public LazyInitClass getInstance() {
        if(instance == null)
            instance = new LazyInitClass("LazyInitClassFieldName") ;

        return instance ;
    }

}
