package com.xcm.puppy.util;


public class PageLocator {

    /**
     * 获取package
     */
    private static String appPackage = GlobalSettings.appPackage;
    private static String pkg = getAttribute("appPackage", appPackage);

    /**
     * Launch页面
     */
    public static final String cancel_button_android = "id=" + pkg + ":id/btnCancel";
    public static final String activity_button_android = "id=" + pkg + ":id/btn_home_activity";
    public static final String cancel_button_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAImage[1]/UIAButton[1]";

    public static final String go_button_android = "id=" + pkg + ":id/go_main";
    public static final String go_button_ios = "class=UIAButton";

    public static final String back_button_android = "id=" + pkg + ":id/ib_back";
    public static final String back_button_ios = "xpath=//UIAButton[@name='Back']";    //"后退"按钮
    public static final String back2_button_ios = "xpath=//UIAButton[@name='back button']";    //"后退"按钮
    public static final String back3_button_ios = "xpath=//UIAButton[@name='headBack']";    //"后退"按钮
    public static final String back_button_wap = "xpath=//div[@class='baseNav xuanfu']/ul/li/img";    //"后退"按钮

    public static final String close_version_button_android = "id=" + pkg + ":id/btnCancel";
    public static final String close_version_button_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAImage[2]/UIAButton[1]";

    /**
     * 首页
     */
    public static final String home_home_menu_website = "link=首页";
    public static final String home_product_menu_website = "link=我要理财";
    public static final String home_banner_website = "id=slider_name";
    public static final String home_login_link_website = "link=登录";    //页头的"登录"
    public static final String home_reg_link_website = "link=注册";    //页头的"注册"
    public static final String home_logo_website = "css=div.navBG>div>dl>dt>img";
    public static final String home_logo2_website = "class=logo";
    public static final String home_download_link_website = "link=客户端下载";
    public static final String home_help_link_website = "link=常见问题";    //页头的"常见问题"
    public static final String home_security_link_website = "link=安全保障";    //页头的"安全保障"
    public static final String home_new_product_website = "class=pdb10";    //"热销"产品的"立即购买"按钮
    public static final String home_guide_link_website = "link=新手指引";
    public static final String home_about_us_website = "link=信息披露";
    public static final String home_notice_website = "xpath=//div[@id='notice']/div/b/a";
    public static final String home_more_notice_website = "xpath=//div[@id='notice']/dl/dt/a";
    public static final String home_icon01_website = "class=icon01";
    public static final String home_icon02_website = "class=icon02";
    public static final String home_icon03_website = "class=icon03";
    public static final String home_icon04_website = "class=icon04";
    public static final String home_icon05_website = "class=icon05";
    public static final String home_commerce_website = "link=小财迷获准加入中国电子商务协会";
    public static final String home_credit_website = "link=小财迷获邀成为中国电子商务协会信用管理委员会理事单位";
    public static final String home_fund_website = "link=小财迷获准成为上海金融信息行业协会会员";
    public static final String home_info_website = "link=小财迷获准加入上海市信息服务业行业协会";

    public static final String home_reg_pop_website = "xpath=//input[@value='注册领钱']";    //"注册领钱"按钮
    public static final String home_quick_entrance01_website = "xpath=//ul[@class='quickEntrance']/li[1]";
    public static final String home_quick_entrance02_website = "xpath=//ul[@class='quickEntrance']/li[2]";
    public static final String home_quick_entrance03_website = "xpath=//ul[@class='quickEntrance']/li[3]";
    public static final String home_quick_entrance04_website = "xpath=//ul[@class='quickEntrance']/li[4]";

    public static final String home_quick_entrance01_wap = "xpath=//div[@id='fh-top-div']/div[2]/div[1]";    //首页第1个菜单:投资抽奖
    public static final String home_quick_entrance02_wap = "xpath=//div[@id='fh-top-div']/div[2]/div[2]";    //首页第2个菜单:每日签到
    public static final String home_quick_entrance03_wap = "xpath=//div[@id='fh-top-div']/div[2]/div[3]";    //首页第3个菜单:推荐有礼
    public static final String home_quick_entrance04_wap = "xpath=//div[@id='fh-top-div']/div[2]/div[4]";    //首页第4个菜单:新手任务


    public static final String home_product_block_website = "class=recBox";
    public static final String home_product_big_website = "class=productBigBox";
    public static final String home_product_name_website = "class=rec1";
    public static final String home_product_name2_website = "css=span.pdb2>b";
    public static final String home_article_link_website = "class=noticeslh";

    public static final String home_product_name_wap = "class=dropRateTitle";    //精选页:产品名称
    public static final String home_product_box_wap = "class=r_in";    //精选页:产品块


    /**
     * wap广告页
     */
    public static final String ad_new_sale_website = "class=newSaleMain0";
    public static final String ad_friends_share_website = "class=coupon-list";
    public static final String ad_sign_website = "id=now-sign";
    public static final String ad_gift_website = "id=cayBtn";

    public static final String ad_new_sale_wap = "class=rltitle";    //投资抽奖页:最高立减xx
    public static final String ad_friends_share_wap = "class=bt";    //新手任务页:去做任务
    public static final String ad_sign_wap = "id=signGetMoney";    //每日签到页:签到图标
    public static final String ad_gift_wap = "class=yhqTit1";    //领券投资页:您的专属xxx

    /**
     * 帮助中心
     */
    public static final String help_panel_website = "class=invest-flow";
    public static final String help_security_website = "class=history";
    public static final String help_guide_website = "xpath=//div[@class='box']/dl/dd";
    public static final String help_aboutus_website = "class=infoDisBox";
    public static final String help_notice_website = "class=ab_mt1";
    public static final String help_more_notice_website = "class=ab_gg";
    public static final String help_friends_website = "id=inviteFriends";
    public static final String help_sign_website = "id=now-sign";
    public static final String help_security_assurance_website = "class=zc_info";


    /**
     * 下载页
     */
    public static final String download_android_link_website = "link=Android版下载";


    /**
     * 登录页
     */
    public static final String account_button_bottom_android = "id=" + pkg + ":id/rd3";
    public static final String account_button_bottom_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]";    //底部"账户"
    public static final String account_button_bottom_wap = "xpath=//ul[@class='footer']/li[3]";

    public static final String mobile_text_login_android = "id=" + pkg + ":id/et_phone_num";
    public static final String mobile_text_login_ios = "class=UIATextField";
    public static final String mobile_text_login_wap = "id=mobile";

    public static final String next_button_login_android = "id=" + pkg + ":id/btn_confirm_container";
    public static final String next_button_login_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]";
    public static final String next_button_login_wap = "id=nextBtn";

    public static final String login_password_text_android = "id=" + pkg + ":id/et_input";
    public static final String login_password_text_ios = "class=UIASecureTextField";
    public static final String login_password_text_wap = "id=password";

    public static final String login_logon_button_android = "id=" + pkg + ":id/btn_confirm_container";
    public static final String login_logon_button_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]";
    public static final String login_logon_button_wap = "id=passLogin";

    public static final String login_skip_button_android = "id=" + pkg + ":id/tv_right";
    public static final String login_skip_button_ios = "xpath=//UIAButton[@name='跳过  ']";


    public static final String login_password_tab_website = "class=LmHeadActive";
    public static final String login_username_text_website = "id=username";
    public static final String login_password_text_website = "id=password";
    public static final String login_login_button_website = "id=userLoginBtn";
    public static final String login_logout_button_website = "xpath=//a[@gadata='顶部工具栏:手机号']";
    public static final String login_prompt_msg_website = "id=pwdShow";
    public static final String login_reg_button_website = "id=quickLogin";

    /**
     * 产品列表页
     */
    public static final String product_button_bottom_android = "id=" + pkg + ":id/rd2";
    public static final String product_button_bottom_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]";    //底部"理财"
    public static final String product_button_bottom_wap = "xpath=//ul[@class='footer']/li[2]";

    public static final String product_main_title_label_android = "id=" + pkg + ":id/main_title_name";
    public static final String product_main_title_label_ios = "xpath=//UIANavigationBar[1]/UIAStaticText[1]";

    //public static final String product_unit_block_android = "class=android.widget.LinearLayout";
    public static final String product_unit_block_android = "id=" + pkg + ":id/financial_adapter_normal_container";
    public static final String product_unit_block_ios = "class=UIATableCell";
    public static final String product_unit_block_wap = "class=productBox";

    public static final String product_name_label_android = "id=" + pkg + ":id/tv_financial_name";
    public static final String product_name_label_ios = "class=UIAStaticText";


    public static final String product_buy_button_website = "link=转入体验金";
    public static final String product_page_list_website = "id=pageList";
    public static final String product_buy2_button_website = "xpath=//input[@value='立即抢购']";
    public static final String product_name_label_website = "class=pd_name";
    public static final String product_next_page_website = "link=下一页";
    public static final String product_progress_bar_website = "css=div.bfb>p>b";
    public static final String product_sesame_website = "css=div#opensesame>div.new_pd";
    public static final String product_block_website = "class=ilProduct";
    public static final String product_name_website = "css=div.pd_name>span";
    public static final String product_list_name_website = "class=pdTit1";    //产品名称
    public static final String product_search_website = "xpath=//*[@id='inList']/li[1]/a[1]";    //期限: 全部
    public static final String product_search_0_30_website = "link=0-30天";    //0-30天
    public static final String product_search_31_90_website = "link=31-92天";    //31-92天
    public static final String product_search_91_180_website = "link=93-182天";    //93-182天
    public static final String product_search_181_365_website = "link=183-365天";    //183-365天
    public static final String product_search_365_website = "link=365天以上";    //365天以上
    public static final String product_search_status_website = "xpath=//*[@id='inList']/li[3]/a[1]";    //状态: 全部
    public static final String product_search_0_100_website = "link=在售";    //在售
    public static final String product_search_100_website = "link=在售";    //在售
    public static final String product_search_9_11_website = "link=9%-11%";    //9%-11%
    public static final String product_search_11_website = "link=11%以上";    //11%以上
    public static final String product_search_rate_website = "xpath=//*[@id='inList']/li[2]/a[1]";    //收益: 全部
    public static final String product_search_0_7_website = "link=7%以下";    //7%以下
    public static final String product_search_7_9_website = "link=7％-9%";    //7％-9%
    public static final String product_deadline_website = "class=lp5";    //产品块中的"投资期限"
    public static final String product_order_by_deadline_website = "link=投资期限";    //排序: 投资期限
    public static final String product_order_by_rate_website = "link=预期年化";    //排序: 预期年化
    public static final String product_order_by_process_website = "link=投资进度";    //排序: 投资进度
    public static final String product_rate_website = "class=lp4";    //预期年化利率
    public static final String product_process_website = "class=lp12";    //投资进度

    /**
     * 产品详情页
     */
    public static final String product_title_label_android = "id=" + pkg + ":id/tv_financial_name";
    public static final String product_title_label_ios = "xpath=//UIANavigationBar[1]/UIAStaticText[1]";
    public static final String product_title_label_wap = "xpath=//div[@class='baseNav xuanfu']/ul/li[3]";

    public static final String product_day_label_android = "id=" + pkg + ":id/day_text";
    public static final String product_day_label_ios = "xpath=//UIAStaticText[@name='期限']";

    public static final String product_minus_button_android = "id=" + pkg + ":id/iv_sub";
    public static final String product_minus_button_ios = "xpath=//UIAButton[@name='minus']";    //"-"按钮

    public static final String product_buy_button_android = "id=" + pkg + ":id/btn_buyImm";
    public static final String product_buy_button_ios = "xpath=//UIAButton[@name='立即抢购']";    //立即抢购
    public static final String product_buy_button_wap = "xpath=//div[@class='plusMinus']/div[2]";

    public static final String invest_record_button_android = "name=投资记录";
    public static final String invest_record_button_ios = "xpath=//UIATableCell[@name='投资记录']";    //投资记录
    public static final String invest_record_button_wap = "xpath=//div[@id='znr']/ul/li[4]";    //投资记录

    public static final String product_project_button_wap = "xpath=//div[@id='znr']/ul/li[3]";    //投资项目

    public static final String product_bank_button_wap = "xpath=//div[@id='znr']/ul/li[5]";    //投资银行

    public static final String project_info_button_android = "name=项目详情";
    public static final String project_info_button_ios = "xpath=//UIATableCell[@name='项目详情']";    //项目详情
    public static final String project_info_button_wap = "xpath=//div[@id='znr']/ul/li[1]";    //项目详情

    public static final String safe_protect_button_android = "name=安全保障";
    public static final String safe_protect_button_ios = "xpath=//UIATableCell[@name='安全保障']";    //安全保障
    public static final String safe_protect_button_wap = "xpath=//div[@id='znr']/ul/li[2]";    //安全保障

    public static final String product_info_title_android="id=" + pkg + ":id/main_title_name";
    public static final String product_info_title_ios="xpath=//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]";

    public static final String product_info_invest_count_label_android="id=" + pkg + ":id/tv_bought_num";
    public static final String product_info_invest_count_label_ios="xpath=//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]";

    public static final String product_info_content_android="class=android.view.View";
    public static final String product_info_content_ios="class=UIAWebView";


    public static final String product_detail_rule_label_website = "class=ib13";    //购买规则
    public static final String product_detail_available_amount_website = "class=ib5";    //剩余可投
    public static final String product_detail_amount_text_website = "id=amount";
    public static final String product_detail_buy_button_website = "id=tendsub";
    public static final String product_detail_name_website = "class=pdTit1";
    public static final String product_detail_sesame_website = "class=zmkmBox1";
    public static final String product_detail_tab1_menu_website = "id=tb1_1";    //"产品详情"选项卡
    public static final String product_detail_tab3_menu_website = "id=tb1_3";    //"投资记录"选项卡
    public static final String product_detail_info_title_website = "css=dl.in_pinfo>dt";    //"产品详情"选项卡下信息标题
    public static final String product_detail_order_title_website = "css=tbody>tr>th";    //"产品详情"选项卡下信息标题

    public static final String product_detail_description_wap = "class=description";    //描述信息

    public static final String product_project_service_wap = "link=《投资计划服务协议》";    //项目详情:《投资计划服务协议》
    public static final String product_safe_title_wap = "class=pjTitlePro";    //安全保障:标题
    public static final String product_invest_title_wap = "class=investTitle";    //投资记录:标题
    public static final String product_bank_icon_wap = "class=nlIcon1";    //支持银行:图标


    /**
     * 确认购买页
     */
    public static final String purchase_day_label_android = "id=" + pkg + ":id/tv_max_time";
    public static final String purchase_day_label_ios = "xpath=//UIATableView[1]/UIAStaticText[3]";

    public static final String purchase_checkout_button_android = "id=" + pkg + ":id/btn_confirm_container";
    public static final String purchase_checkout_button_ios = "xpath=//UIAWindow[1]/UIAButton[1]";
    public static final String purchase_checkout_button_wap =  "class=fw";    //"还需充值xx"按钮

    public static final String purchase_sina_label_android = "id=" + pkg + ":id/main_title_name";
    public static final String purchase_sina_label_ios = "xpath=//UIANavigationBar[1]/UIAStaticText[1]";
    public static final String purchase_sina_label_wap = "class=order_info_showmore";

    public static final String purchase_expected_label_website = "id=expectincome_rec";
    public static final String purchase_buy_button_website = "id=actualPayment_pay";
    public static final String purchase_recharge_button_website = "id=needRechargeAmount_bk";
    public static final String purchase_sina_label_website = "link=订单详情";

    /**
     * 账户
     */
    public static final String account_login_button_android = "id=" + pkg + ":id/ll_mine_login";
    public static final String account_login_button_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]";    //"登录"
    public static final String account_login_button_wap = "xpath=//input[@value='登录']";

    public static final String account_balance_label_android = "id=" + pkg + ":id/tv_item_rightname";
    public static final String account_balance_label_ios = "xpath=//UIATableView[1]/UIATableCell[1]/UIAStaticText[2]";
    public static final String account_balance_label_wap = "id=totalMoneySpan";

    public static final String account_favicon_android = "id=" + pkg + ":id/iv_head_portrait";
    public static final String account_favicon_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[4]";    //头像

    public static final String account_logout_button_android = "id=" + pkg + ":id/btn_logout";
    public static final String account_logout_button_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAButton[1]";    //

    public static final String account_table_cell_android = "id=" + pkg + ":id/rl_useful_record";
    public static final String account_table_cell_ios = "class=UIATableCell";

    public static final String account_table_content1_android = "class=android.widget.ScrollView";
    public static final String account_table_content1_ios = "xpath=//UIATableView/UIATableCell";

    public static final String account_table_content2_android = "class=android.widget.ListView";
    public static final String account_table_content2_ios = "xpath=//UIATableView/UIAStaticText";

    public static final String account_table_content3_ios = "xpath=//UIAScrollView/UIAWebView";

    public static final String account_home_button_website = "link=我的账户";
    public static final String account_navigation_website = "xpath=//dd/a/span";
    public static final String account_content_website = "class=assets";

    public static final String account_nav01_wap = "id=balanceSpan";    //账户首页:可用余额
    public static final String account_recharge_menu_wap = "id=czLi";    //可用余额页:充值
    public static final String account_money_number_wap = "id=money";    //充值页:充值金额输入框
    public static final String account_recharge_button_wap = "id=receive-phone";    //充值页:下一步

    public static final String account_nav02_wap = "id=goldSpan";    //账户首页:体验金
    public static final String account_gold_list_wap = "id=showList";    //体验金页:列表

    public static final String account_nav03_wap = "id=goldProductSpan";    //账户首页:芝麻开门
    public static final String account_ctx_wap = "id=ctx";    //芝麻开门页

    public static final String account_nav04_wap = "id=couponSpan";    //账户首页:优惠券
    public static final String account_coupon_tab1_wap = "xpath=//body/div/div[2]/ul/li[1]";  //优惠券页:未使用
    public static final String account_coupon_tab2_wap = "xpath=//body/div/div[2]/ul/li[2]";  //优惠券页:已使用
    public static final String account_coupon_tab3_wap = "xpath=//body/div/div[2]/ul/li[3]";  //优惠券页:已过期
    public static final String account_coupon_wap = "class=couponsUp";    //优惠券页:优惠券

    public static final String account_nav05_wap = "xpath=//div[@id='fh-top-div']/ul/li[5]";    //账户首页:持有资产
    public static final String account_finish_link_wap = "link=已完成";    //持有资产页:已完成xx笔
    public static final String account_asset_list_wap = "xpath=//div[@id='showList']/div";    //已完成xx笔页:订单
    public static final String account_agreement_wap = "xpath=/html/body/div/div[6]/div[2]";    //订单详情页:服务协议
    public static final String account_agreement_title_wap = "xpath=/html/body/h1";    //协议标题
    public static final String account_invest_wap = "xpath=/html/body/div/div[6]/div[1]";    //订单详情页:投资项目
    public static final String account_invest_item_wap = "xpath=//ul[@id='showList']/li";    //投资项目页:标的

    public static final String account_available_balance_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]";  //账户首页:第1个菜单:可用余额
    public static final String account_experience_gold_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]";  //账户首页:第2个菜单:体验金
    public static final String account_gold_product_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]";  //账户首页:第3个菜单:芝麻开门
    public static final String account_coupon_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]";  //账户首页:第4个菜单:优惠券
    public static final String account_order_record_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]";  //账户首页:第5个菜单:交易记录
    public static final String account_refund_calendar_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[6]";  //账户首页:第6个菜单:回款日历
    public static final String account_shipping_address_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[7]";  //账户首页:第7个菜单:收货地址

    /**
     * 可用余额页
     */
    public static final String account_charge_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]";  //可用余额:充值
    public static final String account_cash_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]";  //可用余额:提现
    public static final String account_cash_record_menu_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]";  //可用余额:资金记录
    public static final String account_available_balance_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAStaticText[1]";  //可用余额:可用余额

    public static final String account_money_input_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATextField[1]";  //充值页面:金额输入框
    public static final String account_money_limit_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]";  //充值页面: 充值限额
    public static final String account_money_submit_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAButton[2]";  //充值页面:下一步
    public static final String account_fee_link_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]";  //提现页面:如何免费提现
    public static final String account_fee_content_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]";  //提现说明:如何获得免费提现机会?
    public static final String account_cash_record_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]";  //资金记录:如何获得免费提现机会?

    public static final String account_gold_record_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]";  //体验金页:"投资项目成功扣除"
    public static final String account_gold_product_content_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]";  //芝麻开门页:年化收益

    public static final String account_coupon_content_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]";  //账户首页:第4个菜单:优惠券
    public static final String account_order_record_content_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]";  //账户首页:第5个菜单:交易记录
    public static final String account_refund_calendar_content_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[6]";  //账户首页:第6个菜单:回款日历
    public static final String account_shipping_address_content_ios = "xpath=//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[2]";  //收货地址页:手机号


    /**
     * 更多
     */
    public static final String more_button_android = "id=" + pkg + ":id/rd4";
    public static final String more_button_ios = "xpath=//UIAButton[@name='更多']";    //底部"更多"

    public static final String aboutus_button_android = "id=" + pkg + ":id/tv_left_text";
    public static final String aboutus_button_ios = "xpath=//UIATableCell[@name='关于我们']";

    public static final String aboutus_content_android = "class=android.widget.Image";
    public static final String aboutus_content_ios = "xpath=//UIAWebView[1]/UIAImage[1]";


    /**
     * 获取属性
     *
     * @param envAttribute
     * @param globalSettingsAttribute
     * @return
     */
    private static String getAttribute(String envAttribute, String globalSettingsAttribute) {
        String attribute = System.getProperty(envAttribute);
        return ("${" + envAttribute + "}").equals(attribute) || null == attribute ? globalSettingsAttribute : attribute;
    }

}
