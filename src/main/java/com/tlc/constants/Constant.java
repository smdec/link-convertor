package com.tlc.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public final String DEEPLINK_SEARCH_TEMPLATE = "ty://?Page=Search&Query=${Query}";
    public final String WEB_URL_SEARCH_TEMPLATE = "https://www.trendyol.com/sr?q=${Query}";
    public final String WEB_URL_PRODUCT_PAGE = "https://www.trendyol.com/brand/name-p-";
    public final String WEB_URL_PRODUCT_ID_PARAM = "productId";
    public final String WEB_URL_PRODUCT_DETAIL_PARAM = "-p-";
    public final String WEB_URL_SEARCH_PAGE_PARAM = "/sr";

    public final String DEEPLINK_HOME_TEMPLATE = "ty://?Page=Home";
    public final String WEB_URL_HOME_TEMPLATE = "https://www.trendyol.com";

    public final String DEEP_LINK_HOST = "ty";
    public final String DEEP_LINK_PAGE_PARAM = "page";
    public final String DEEP_LINK_PAGE_PARAM_VALUE = "Product";
    public final String DEEP_LINK_CONTENT_ID_PARAM = "ContentId";
    public final String DEEP_LINK_PRODUCT_DETAIL_PARAM = "Product";
    public final String DEEP_LINK_SEARCH_PARAM = "Search";
}
