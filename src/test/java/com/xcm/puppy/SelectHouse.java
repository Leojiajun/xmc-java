package com.xcm.puppy;

import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by tim on 7/19/16.
 */
public class SelectHouse {

    private WebDriver driver;
    private Selenium selenium;

    @BeforeTest(alwaysRun = true)
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        selenium = new Selenium(driver);
        selenium.open("http://select.pdgzf.com/Index.aspx");

        selenium.sendkeys("id=UserName", "18601722236");
        //selenium.sendkeys("id=PassWord", "K871120");

        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        selenium.click("id=EmpLogin");
    }

    @Test(alwaysRun = true)
    public void lookup() {
        for (int i = 0; i < 30000; i++) {

            selenium.open("http://select.pdgzf.com/Admin/personalSelect.aspx?xm=%E6%9E%A3%E5%BA%84%E8%B7%AF1029%E5%BC%84");
            //selenium.open("http://select.pdgzf.com/Admin/personalSelect.aspx?xm=%E5%A6%99%E5%B7%9D%E8%B7%AF800%E5%BC%84%EF%BC%88%E5%B7%9D%E6%B2%99%E5%8D%9A%E6%99%AF%E8%8B%91%EF%BC%89");
            String content = selenium.getText("class=list");
            if (null == content || "".equals(content)) {
                System.out.println("第 " + i + " 次");
                try {
                    Thread.currentThread().sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(content);
                break;
            }

        }
    }


}
