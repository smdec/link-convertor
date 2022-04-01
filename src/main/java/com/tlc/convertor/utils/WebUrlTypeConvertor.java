package com.tlc.convertor.utils;

import com.tlc.convertor.enums.WebUrlType;
import lombok.experimental.UtilityClass;

/**
 * Represents convertor type
 *
 */
@UtilityClass
public class WebUrlTypeConvertor {
    /**
     * Method return type of WebUrl convertor
     *
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
