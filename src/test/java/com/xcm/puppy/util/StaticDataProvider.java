package com.xcm.puppy.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    @DataProvider(name = "LandingPageData4Test")
    public static Object[][] getLandingPageData4Test()
    {
        return new Object[][] {
                {"http://m.91xcm.com/share.html", "id=regForm"},
                {"http://m.91xcm.com/channel/chubao.html", "id=regForm"},
                {"http://m.91xcm.com/channel/wuyou.html", "id=regForm"},
                {"http://m.91xcm.com/channel/general_lbb.html", "id=regForm"},
                {"http://m.91xcm.com/channel/sem.html", "id=regForm"},
                {"http://m.91xcm.com/channel/gewala.html", "id=regForm"},
                {"http://m.91xcm.com/channel/fuyi.html", "id=regForm"},
                {"http://m.91xcm.com/channel/shenshu.html", "id=regForm"},
                {"http://m.91xcm.com/channel/liuliang.html", "id=regForm"},
                {"http://m.91xcm.com/channel/sem01.html", "id=regForm"},
                {"http://m.91xcm.com/channel/niubi.html", "id=mobile"},
                {"http://m.91xcm.com/channel/edaixi.html", "id=hasBottom"},
                {"http://m.91xcm.com/channel/zzw.html", "id=regForm"},
                {"http://m.91xcm.com/channel/liumi.html", "id=regForm"},
                {"http://m.91xcm.com/channel/chelun.html", "id=moblieBox"},
                {"http://m.91xcm.com/channel/quanmama.html", "id=regForm"},
                {"http://m.91xcm.com/channel/maizuo.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/huanle/index.html", "xpath=/html/body/div/div/br[1]"},
                {"http://m.91xcm.com/mchannel/liuliangbao/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/wuyou_wx/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/quanmin/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/jinshan/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/xiaotongren/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/wahaha/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/sem02/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/ximalaya/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/liqu/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/lechebang/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/sem03/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/mingpinjie/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/zdnz/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/pinyou/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/10086/index.html", "id=regForm"},
                {"http://m.91xcm.com/mchannel/10010/index.html", "id=regForm"},
                {"http://m.91xcm.com/event/jinDaShiLP.do", "id=choujiang"}

        };
    }

    @DataProvider(name = "AccountData4CouponTest")
    public static Object[][] getAccountData4CouponTest()
    {
        return new Object[][] {
                {PageLocator.account_coupon_tab2_wap},
                {PageLocator.account_coupon_tab3_wap}
        };
    }

    @DataProvider(name = "ProductData4ItemTest")
    public static Object[][] getProductData4ItemTest()
    {
        return new Object[][] {
                {PageLocator.project_info_button_wap, PageLocator.product_project_service_wap},
                {PageLocator.safe_protect_button_wap, PageLocator.product_safe_title_wap},
                {PageLocator.invest_record_button_wap, PageLocator.product_invest_title_wap},
                {PageLocator.product_bank_button_wap, PageLocator.product_bank_icon_wap}
        };
    }

    @DataProvider(name = "HomeTestData4menuTest")
    public static Object[][] getHomeTestData4menuTest() {
        return new Object[][]{
                {PageLocator.home_quick_entrance01_wap, PageLocator.ad_new_sale_wap},
                {PageLocator.home_quick_entrance02_wap, PageLocator.ad_sign_wap},
                {PageLocator.home_quick_entrance03_wap, PageLocator.ad_friends_share_wap},
                {PageLocator.home_quick_entrance04_wap, PageLocator.ad_gift_wap}
        };
    }

    @DataProvider(name = "ProductTestData4StatusTest")
    public static Object[][] getProductTestData4StatusTest() {
        return new Object[][]{
                {PageLocator.product_search_0_100_website, PageLocator.product_order_by_process_website},
                {PageLocator.product_search_status_website, PageLocator.product_order_by_process_website}
        };
    }

    @DataProvider(name = "ProductTestData4IncomeTest")
    public static Object[][] getProductTestData4IncomeTest() {
        return new Object[][]{
                {PageLocator.product_search_0_7_website, PageLocator.product_order_by_rate_website},
                {PageLocator.product_search_7_9_website, PageLocator.product_order_by_rate_website},
                {PageLocator.product_search_9_11_website, PageLocator.product_order_by_rate_website},
                {PageLocator.product_search_11_website, PageLocator.product_order_by_rate_website},
                {PageLocator.product_search_rate_website, PageLocator.product_order_by_rate_website}
        };
    }

    @DataProvider(name = "ProductTestData4DeadlineTest")
    public static Object[][] getProductTestData4DeadlineTest() {
        return new Object[][]{
                {PageLocator.product_search_0_30_website, PageLocator.product_order_by_deadline_website},
                {PageLocator.product_search_31_90_website, PageLocator.product_order_by_deadline_website},
                {PageLocator.product_search_91_180_website, PageLocator.product_order_by_deadline_website},
                {PageLocator.product_search_181_365_website, PageLocator.product_order_by_deadline_website},
                {PageLocator.product_search_365_website, PageLocator.product_order_by_deadline_website},
                {PageLocator.product_search_website, PageLocator.product_order_by_deadline_website}
        };
    }

    @DataProvider(name = "HomeTestData4NewWindowTest")
    public static Object[][] getHomeTestData4NewWindowTest() {
        return new Object[][]{
                {PageLocator.home_notice_website, PageLocator.help_notice_website},
                {PageLocator.home_commerce_website, PageLocator.help_notice_website},
                {PageLocator.home_credit_website, PageLocator.help_notice_website},
                {PageLocator.home_fund_website, PageLocator.help_notice_website},
                {PageLocator.home_info_website, PageLocator.help_notice_website}
        };
    }

    @DataProvider(name = "HomeTestData4LinkTest")
    public static Object[][] getHomeTestData4LinkTest() {
        return new Object[][]{
                {PageLocator.home_login_link_website, PageLocator.login_login_button_website},
                {PageLocator.home_reg_link_website, PageLocator.login_reg_button_website},
                {PageLocator.home_reg_pop_website, PageLocator.login_reg_button_website},
                {PageLocator.home_help_link_website, PageLocator.help_panel_website},
                {PageLocator.home_security_link_website, PageLocator.help_security_website},
                {PageLocator.home_quick_entrance01_website, PageLocator.ad_new_sale_website},
                {PageLocator.home_quick_entrance02_website, PageLocator.ad_friends_share_website},
                {PageLocator.home_quick_entrance03_website, PageLocator.ad_sign_website},
                {PageLocator.home_quick_entrance04_website, PageLocator.ad_gift_website},
                {PageLocator.home_new_product_website, PageLocator.product_detail_amount_text_website},
                {PageLocator.home_guide_link_website, PageLocator.help_guide_website},
                {PageLocator.home_about_us_website, PageLocator.help_aboutus_website},
                {PageLocator.home_more_notice_website, PageLocator.help_more_notice_website}
        };
    }

    @DataProvider(name = "PageData4LandingPage")
    public static Object[][] getPageData4LandingPage() throws IOException {
        return getData("test-data/landing_page_in_wap.xlsx");
    }

    @DataProvider(name = "data4ProductRelease")
    public static Object[][] getData4ProductRelease() throws IOException {
        return getData("test-data/product_data_for_product_release.xlsx");
    }

    @DataProvider(name = "data4Demo")
    public static Object[][] getData4Demo() throws IOException {
        return getData("test-data/TestData4Demo.xlsx");
    }

    /**
     * 读取excel文件，返回一个Object二维数组，用于testng的数据驱动
     *
     * @param file excel的文件路径
     * @return Object二维数组
     * @throws IOException
     */
    public static Object[][] getData(String file) throws IOException {
        InputStream is = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(is);
        Sheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        Object[][] records = new Object[rowNum][];
        for (int i = 1; i <= rowNum; i++) {
            XSSFRow row = (XSSFRow) sheet.getRow(i);
            int colNum = row.getLastCellNum();
            Object[] data = new Object[colNum];
            for (int j = 0; j < colNum; j++) {
                data[j] = row.getCell(j).getStringCellValue();
            }
            records[i - 1] = data;
        }
        return records;
    }

    public static void main(String[] args) throws Exception
    {
        Object[][] objs = getData("test-data/landing_page_in_wap.xlsx");
        int rows = objs.length;
        for(int i=0; i<rows; i++)
        {
            int cols = objs[i].length;
            for(int j=0; j<cols; j++)
            {
                System.out.print(objs[i][j] + " ");

            }
            System.out.println("");

        }
    }


}
