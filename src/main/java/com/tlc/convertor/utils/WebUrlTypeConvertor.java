package com.tlc.convertor.utils;

import com.tlc.convertor.enums.WebUrlType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WebUrlTypeConvertor {
    /**
     * @param url
     * @return WebUrlType
     */
    public WebUrlType getType(String url) {
        if (url.contains("Product&ContentId")) {
            return WebUrlType.PRODUCT_DETAIL;
        } else if (url.contains("Search&Query")) {
            return WebUrlType.SEARCH;
        } else {
            return WebUrlType.HOME;
        }
    }
}
