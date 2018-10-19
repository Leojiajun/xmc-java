package com.xcm.puppy.util;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by jenkins on 24/10/16.
 */
public class RetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation testAnnotation, Class aClass, Constructor constructor, Method method) {
        if(null == testAnnotation.getRetryAnalyzer())
        {
            testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }
}
