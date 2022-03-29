package com.tlc.convertor.factory.webdeeplink;

import com.tlc.convertor.enums.UrlType;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeepLinkConvertorFactory {
    public Convertor getConvertor(UrlType type) {
        switch (type) {
            case PRODUCT_DETAIL:
                return new ProductDetailDeeplinkConvertor();
            case SEARCH:
                return new SearchDeeplinkConvertor();
            case HOME:
                return new HomeLinkConvertor();
            default:
                throw new IllegalArgumentException("Unknown type " + type);
        }
    }
}
