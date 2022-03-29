package com.tlc.convertor.factory.weburl;

import com.tlc.convertor.enums.UrlType;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Slf4j
public class WebUrlConvertorFactory {
    public Convertor getConvertor(UrlType type) {
        switch (type) {
            case PRODUCT_DETAIL:
                return new ProductDetailWebUrlConvertor();
            case SEARCH:
                return new SearchWebUrlConvertor();
            case HOME:
                return new HomeWebUrlConvertor();
            default:
                throw new IllegalArgumentException("Unknown type " + type);
        }
    }
}
