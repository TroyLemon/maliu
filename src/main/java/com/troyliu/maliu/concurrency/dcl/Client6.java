package com.troyliu.maliu.concurrency.dcl;

/**
 * code 4.1 代码
 * @author TroyLiu
 * @version 1.0
 * @date 2021/3/28 22:37
 */
public class Client6 {

    private static class LazyInitClassHolder {
        static LazyInitClass singleton = new LazyInitClass("LazyInitClassFieldName");
    }

    public static LazyInitClass getInstance() {
        return LazyInitClassHolder.singleton ;
    }

}
