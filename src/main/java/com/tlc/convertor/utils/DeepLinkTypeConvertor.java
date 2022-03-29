package com.tlc.convertor.utils;

import com.tlc.convertor.enums.DeeplinkType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DeepLinkTypeConvertor {
    /**
     * @param url
     * @return DeeplinkType
     */
    public DeeplinkType getType(String url) {
        if (url.contains("-p-")) {
            return DeeplinkType.PRODUCT_DETAIL;
        } else if (url.contains("/sr")) {
            return DeeplinkType.SEARCH;
        } else {
            return DeeplinkType.HOME;
        }
    }
}
