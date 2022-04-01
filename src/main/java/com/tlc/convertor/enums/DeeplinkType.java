package com.tlc.convertor.enums;

import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.factory.webdeeplink.HomeDeeplinkConvertor;
import com.tlc.convertor.factory.webdeeplink.ProductDetailDeeplinkConvertor;
import com.tlc.convertor.factory.webdeeplink.SearchDeeplinkConvertor;


/**
 * Represents enum DeeplinkType for deep link converting
 */
public enum DeeplinkType {
    PRODUCT_DETAIL(new ProductDetailDeeplinkConvertor()),
    SEARCH(new SearchDeeplinkConvertor()),
    HOME(new HomeDeeplinkConvertor());

    private final Convertor convertor;

    DeeplinkType(Convertor convertor) {
        this.convertor = convertor;
    }

    public Convertor getConvertor() {
        return convertor;
    }
}
