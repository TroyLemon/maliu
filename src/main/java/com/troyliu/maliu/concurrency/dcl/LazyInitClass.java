package com.troyliu.maliu.concurrency.dcl;

import com.troyliu.maliu.annotation.NotThreadSafe;

/**
 * code 1.4 代码
 * @author TroyLiu
 * @version 1.0
 * @date 2021/3/28 18:27
 */
@NotThreadSafe
public class LazyInitClass {

    private String lazyInitClassField ;

    public LazyInitClass(String lazyInitClassField) {
        this.lazyInitClassField = lazyInitClassField ;
    }

    public String getLazyInitClassField() {
        return lazyInitClassField;
    }

    public void setLazyInitClassField(String lazyInitClassField) {
        this.lazyInitClassField = lazyInitClassField;
    }
}
