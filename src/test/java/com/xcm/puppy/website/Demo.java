package com.xcm.puppy.website;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by jenkins on 19/8/16.
 */
public class Demo {

    @Test(alwaysRun = true)
    public void test() {
        Assert.assertTrue("abc".equals("bcd"));
    }



}
