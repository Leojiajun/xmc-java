package com.xcm.puppy;

import com.xcm.puppy.util.ApacheHttpClient;
import org.testng.annotations.Test;

/**
 * Created by jenkins on 4/8/16.
 */
public class HttpClientTest {

    @Test(alwaysRun = true)
    public void test()
    {
        ApacheHttpClient httpClient = new ApacheHttpClient();
        String msg = httpClient.getResponse("http://www.baidu.com");
        System.out.println(msg);

    }
}
