package com.tlc.convertor.utils;

import com.tlc.convertor.enums.UrlType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DeepLinkTypeConvertor {

    public UrlType getType(String url) {
        if (url.contains("-p-")) {
            return UrlType.PRODUCT_DETAIL;
        } else if (url.contains("/sr")) {
            return UrlType.SEARCH;
        } else {
            return UrlType.HOME;
        }
    }
}
