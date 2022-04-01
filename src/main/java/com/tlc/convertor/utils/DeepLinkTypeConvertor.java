package com.tlc.convertor.utils;

import com.tlc.convertor.enums.DeeplinkType;
import lombok.experimental.UtilityClass;

/**
 * Represents convertor type
 *
 */
@UtilityClass
public class DeepLinkTypeConvertor {
    /**
     * Method return type of Deeplink convertor
     *
     * @param url
     * @return WebUrlType
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
