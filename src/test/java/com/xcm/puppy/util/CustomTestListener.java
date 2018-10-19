package com.xcm.puppy.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.*;

/**
 * Created by jenkins on 1/11/16.
 */
public class CustomTestListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext context) {

        List<ITestResult> failedResultsToBeRemoved = new ArrayList<ITestResult>();
        List<ITestResult> skippedResultsToBeRemoved = new ArrayList<ITestResult>();
        Set<String> failedTests = new HashSet<String>();
        Set<String> passedTests = new HashSet<String>();
        Set<String> skippedTests = new HashSet<String>();

        Set<ITestResult> passedResults = context.getPassedTests().getAllResults();
        for (ITestResult testResult : passedResults) {
            String methodName = getTestMethod(testResult);
            passedTests.add(methodName);
        }

        Set<ITestResult> failedResults = context.getFailedTests().getAllResults();
        for (ITestResult testResult : failedResults) {
            String methodName = getTestMethod(testResult);
            if (failedTests.contains(methodName) || passedTests.contains(methodName)) {
                failedResultsToBeRemoved.add(testResult);
            } else {
                failedTests.add(methodName);
            }
        }

        Set<ITestResult> skippedResults = context.getSkippedTests().getAllResults();
        for (ITestResult testResult : skippedResults) {
            String methodName = getTestMethod(testResult);
            if (skippedTests.contains(methodName) || passedTests.contains(methodName)) {
                failedResultsToBeRemoved.add(testResult);
            } else if (failedTests.contains(methodName)) {
                skippedResultsToBeRemoved.add(testResult);
            } else {
                skippedTests.add(methodName);
            }
        }

        Set<ITestResult> results = context.getFailedTests().getAllResults();
        for (ITestResult result : results) {
            if (failedResultsToBeRemoved.contains(result)) {
                results.remove(result);
            }
        }

        Set<ITestResult> sResults = context.getSkippedTests().getAllResults();
        for (ITestResult result : sResults) {
            if (failedResultsToBeRemoved.contains(result) || skippedResultsToBeRemoved.contains(result)) {
                sResults.remove(result);
            }
        }

    }

    private String getTestMethod(ITestResult testResult) {
        String className = testResult.getTestClass().getName();
        String methodName = testResult.getMethod().getMethodName();
        String param = "";
        Object[] parameters = testResult.getParameters();
        for (Object parameter : parameters) {
            param = param + parameter + " | ";
        }
        String testMethod = className + "." + methodName + " | " + param;
        return testMethod;
    }


}
