package com.tlc.convertor.enums;

import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.factory.weburl.HomeWebUrlConvertor;
import com.tlc.convertor.factory.weburl.ProductDetailWebUrlConvertor;
import com.tlc.convertor.factory.weburl.SearchWebUrlConvertor;

public enum WebUrlType {
    PRODUCT_DETAIL(new ProductDetailWebUrlConvertor()),
    SEARCH(new SearchWebUrlConvertor()),
    HOME(new HomeWebUrlConvertor());

    private final Convertor convertor;

    WebUrlType(Convertor convertor) {
        this.convertor = convertor;
    }

    public Convertor getConvertor() {
        return convertor;
    }
}
