package com.example.taxiAppEE.web;

public final class Path {

    // pages
    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
    public static final String PAGE_LIST_MENU = "/WEB-INF/jsp/client/list_menu.jsp";
    public static final String PAGE_LIST_ORDERS = "/WEB-INF/jsp/admin/list_orders.jsp";
    public static final String PAGE_SETTINGS = "/WEB-INF/jsp/settings.jsp";

    public static final String PAGE_MAIN = "/WEB-INF/jsp/main.jsp";
    public static final String PAGE_PRICES = "/WEB-INF/jsp/prices.jsp";
    public static final String PAGE_ADMIN = "/WEB-INF/jsp/admin/admin-panel.jsp";
    public static final String PAGE_REGISTRATION = "/WEB-INF/jsp/registration.jsp";
    public static final String PAGE_PROFILE = "/WEB-INF/jsp/user/profile-page.jsp";
    public static final String PAGE_MAKE_ORDER = "/WEB-INF/jsp/order/make-order.jsp";
    public static final String PAGE_CONFIRMATION = "/WEB-INF/jsp/order/confirmation.jsp";
    public static final String PAGE_SUCCESS = "/WEB-INF/jsp/order/order-success.jsp";


    // commands
    public static final String COMMAND_LIST_ORDERS = "/controllerlistOrders";
    public static final String COMMAND_LIST_MENU = "/controllerlistMenu";

    // redirect
    public static final String REDIRECT_PAGE_MAIN = "/?redirect=/main";
    public static final String REDIRECT_PAGE_LOGIN = "/?redirect=/login";
    public static final String REDIRECT_PAGE_ERROR = "/?redirect=/error";
    public static final String REDIRECT_PAGE_SUCCESS = "/?redirect=/success";
    public static final String REDIRECT_PAGE_CONFIRMATION = "/?redirect=/confirmationPage";
}