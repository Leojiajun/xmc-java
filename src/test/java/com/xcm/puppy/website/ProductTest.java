package com.xcm.puppy.website;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.website.HomePage;
import com.xcm.puppy.page.website.ListPage;
import com.xcm.puppy.page.website.ProductPage;
import com.xcm.puppy.util.StaticDataProvider;
import com.xcm.puppy.util.StringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by jenkins on 20/10/16.
 */
public class ProductTest extends BaseTest {
    private HomePage homePage;
    private ProductPage productPage;
    private ListPage listPage;

    @BeforeClass(alwaysRun = true)
    public void init() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        listPage = new ListPage(driver);

        homePage.openListPage();
    }


    // @Test(alwaysRun = true)
    public void openSesame() {
        WebElement element = productPage.openSesame();
        homePage.openListPage();
        Assert.assertNotNull(element);
    }

    @Parameters({"page-no"})
    @Test(alwaysRun = true)
    public void openMultiProduct(@Optional int page) {
        for (int i = 1; i < page; i++) {
            openProduct(i);
        }
    }


    private void openProduct(int page) {
        List<WebElement> elements = productPage.getProductList();
        if (null == elements) {
            Assert.assertTrue(false);
        }
        for (int i = 0; i < elements.size(); i++) {
            List<WebElement> productList = productPage.getProductList();
            WebElement element = productList.get(i);
            selenium.scrollTo(element);
            WebElement product = productPage.getProduct(element);
            String productName = productPage.getProductName(element);
            selenium.click(product);
            String name = productPage.getProduct_name();
            homePage.openListPage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            productPage.openPage(page);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(productName);
            Assert.assertEquals(productName, name);
        }
    }

    @Test(alwaysRun = true, dataProvider = "ProductTestData4DeadlineTest", dataProviderClass = StaticDataProvider.class)
    public void testDeadline(String filter, String sorter) {
        int min = 0;
        int max = 10000;
        String attribute = listPage.search(filter);
        String minStr = StringUtils.substring(attribute, "('", "',");
        String maxStr = StringUtils.substring(attribute, ",'", "')");
        if (!"".equals(minStr)) {
            min = Integer.parseInt(minStr);
        }
        if (!"".equals(maxStr)) {
            max = Integer.parseInt(maxStr);
        }
        for (int i = 0; i < 2; i++) {
            listPage.sort(sorter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> lines = listPage.getDeadline();
            for (String line : lines) {
                int dayCount;
                String day;
                if (line.contains("天")) {
                    int index = line.indexOf("天");
                    day = line.substring(0, index);
                    dayCount = Integer.parseInt(day);
                } else {
                    int index = line.indexOf("个月");
                    day = line.substring(0, index);
                    dayCount = Integer.parseInt(day) * 30;
                }
                //System.out.println(line + " | " + dayCount + " | " + min + " | " + max);
                Assert.assertTrue(min <= dayCount && dayCount <= max);
            }
        }
    }

    @Test(alwaysRun = true, dataProvider = "ProductTestData4IncomeTest", dataProviderClass = StaticDataProvider.class)
    public void testIncome(String filter, String sorter) {
        double min = 0;
        double max = 10000;
        String attribute = listPage.search(filter);
        String minStr = StringUtils.substring(attribute, "('", "',");
        String maxStr = StringUtils.substring(attribute, ",'", "')");
        if (!"".equals(minStr)) {
            min = Double.parseDouble(minStr);
        }
        if (!"".equals(maxStr)) {
            max = Double.parseDouble(maxStr);
        }
        for (int i = 0; i < 2; i++) {
            listPage.sort(sorter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> lines = listPage.getRate();
            for (String line : lines) {
                double dayCount;
                String day;
                int index = line.indexOf("%");
                day = line.substring(0, index);
                dayCount = Double.parseDouble(day);
                //System.out.println(line + " | " + dayCount + " | " + min + " | " + max);
                Assert.assertTrue(min <= dayCount && dayCount < max);
            }
        }
    }

    @Test(alwaysRun = true, dataProvider = "ProductTestData4StatusTest", dataProviderClass = StaticDataProvider.class)
    public void testStatus(String filter, String sorter) {
        int min = 0;
        int max = 100;
        String attribute = listPage.search(filter);
        String minStr = StringUtils.substring(attribute, "('", "')");
        if ("1".equals(minStr)) {
            max = 99;
        } else if ("2".equals(minStr)) {
            min = 100;
        }
        for (int i = 0; i < 2; i++) {
            listPage.sort(sorter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> lines = listPage.getStatus();
            for (String line : lines) {
                int dayCount;
                String day;
                day = StringUtils.substring(line, "已投", "%");
                dayCount = Integer.parseInt(day);
                System.out.println(line + " | " + dayCount + " | " + min + " | " + max);
                Assert.assertTrue(0 <= dayCount && dayCount <= max);
            }
        }
    }


}
