package com.xcm.puppy;

import org.testng.annotations.Test;

/**
 * Created by jenkins on 18/1/17.
 */
public class CDNRelease extends BaseTest {


    @Test(alwaysRun = true)
    public void setUp() throws InterruptedException {
        String style = selenium.getAttribute("id=stop-btn", "style");
        System.out.println("=======before===== : " + style);
        String param = System.getProperty("url-cdn");
        selenium.sendkeys("id=url", param);
        selenium.click("id=su");
        Thread.sleep(60000);
        String style2 = selenium.getAttribute("id=stop-btn", "style");
        System.out.println("=======after===== : " + style2);



    }
}
