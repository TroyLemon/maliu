package com.troyliu.maliu.concurrency.dcl;

/**
 * code 3.1 代码
 * @author TroyLiu
 * @version 1.0
 * @date 2021/3/28 18:24
 */
public class Client3 {

    private final ThreadLocal perThreadInstance = new ThreadLocal();
    private LazyInitClass instance ;
    public LazyInitClass getInstance() {
        if (perThreadInstance.get() == null) createInstance();
        return instance;
    }
    private void createInstance() {
        synchronized(this) {
            if (instance == null)
                instance = new LazyInitClass("LazyInitClassFieldName");
        }
        perThreadInstance.set(perThreadInstance);
    }

}
