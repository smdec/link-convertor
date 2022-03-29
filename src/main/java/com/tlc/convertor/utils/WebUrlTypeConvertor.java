package com.tlc.convertor.utils;

import com.tlc.convertor.enums.UrlType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WebUrlTypeConvertor {
    public UrlType getType(String url) {
        if (url.contains("Product&ContentId")) {
            return UrlType.PRODUCT_DETAIL;
        } else if (url.contains("Search&Query")) {
            return UrlType.SEARCH;
        } else {
            return UrlType.HOME;
        }
    }
}
