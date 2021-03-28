package com.troyliu.maliu.concurrency.dcl;

import com.troyliu.maliu.annotation.ThreadSafe;

/**
 * code 3.4 代码
 * @author TroyLiu
 * @version 1.0
 * @date 2021/3/28 18:27
 */
@ThreadSafe
public class ImmutableLazyInitClass {

    private final String lazyInitClassField ;

    public ImmutableLazyInitClass(String lazyInitClassField) {
        this.lazyInitClassField = lazyInitClassField ;
    }

    public String getLazyInitClassField() {
        return lazyInitClassField;
    }
}
