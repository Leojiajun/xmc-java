package com.xcm.puppy.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GlobalSettings {

    public static Properties settings = getProperties("settings.properties");

    public static String driverType = settings.getProperty("driverType", "Android");
    public static String remoteAddress = settings.getProperty("remoteAddress", "http://127.0.0.1:4723/wd/hub");
    public static String apkPath = settings.getProperty("apkPath");
    public static String ipaPath = settings.getProperty("ipaPath");
    public static String platformName = settings.getProperty("platformName");
    public static String platformVersion = settings.getProperty("platformVersion");
    public static String deviceName = settings.getProperty("deviceName");
    public static String udid = settings.getProperty("udid");
    public static String bundleId = settings.getProperty("bundleId");
    public static String appActivity = settings.getProperty("appActivity");
    public static String appPackage = settings.getProperty("appPackage");
    public static String firefoxBinary = settings.getProperty("firefoxBinary");
    public static String chromeBinary = settings.getProperty("chromeBinary");
    public static String baseUrl = settings.getProperty("baseUrl");
    public static String browserName = settings.getProperty("browserName", "");
    public static long timeOutInSeconds = Long.parseLong(settings.getProperty("timeOutInSeconds", "10"));
    public static boolean takingScreenshots = Boolean.parseBoolean(settings.getProperty("takingScreenshots", "false"));
    public static int retryCount = Integer.parseInt(settings.getProperty("retryAnalyzerCount"));

    /**
     * 读取properties文件
     *
     * @param fileName
     * @return
     */
    public static Properties getProperties(String fileName) {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro;
    }

}
