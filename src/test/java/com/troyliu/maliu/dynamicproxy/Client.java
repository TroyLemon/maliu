package com.troyliu.maliu.dynamicproxy;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author TroyLiu
 * @version 1.0
 * @date 2021/04/04 10.02
 */
public class Client {

    @Test
    public void testAssignable() {
        Assert.assertFalse(Double.class.isAssignableFrom(Number.class)) ;
        Assert.assertTrue(Number.class.isAssignableFrom(Double.class)) ;
    }


}
