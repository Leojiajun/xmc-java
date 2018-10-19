package com.xcm.puppy.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by jenkins on 24/10/16.
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 1;
    private int maxCount = GlobalSettings.retryCount;
    public boolean retry(ITestResult testResult) {
        while (count <= maxCount)
        {
            Reporter.setCurrentTestResult(testResult);
            count++;
            return true;
        }

        return false;
    }
}
