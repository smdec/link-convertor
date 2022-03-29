package com.tlc.convertor;

import com.tlc.convertor.factory.webdeeplink.DeepLinkConvertorFactory;
import com.tlc.convertor.factory.weburl.WebUrlConvertorFactory;
import com.tlc.convertor.utils.DeepLinkTypeConvertor;
import com.tlc.convertor.utils.WebUrlTypeConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UrlConvertor {

    private final DeepLinkConvertorFactory deepLinkFactory;
    private final WebUrlConvertorFactory urlConvertorFactory;

    public String convertToDeepLink(String origin) {
        return deepLinkFactory.getConvertor(DeepLinkTypeConvertor.getType(origin)).convert(origin);
    }

    public String convertToUrl(String origin) {
        return urlConvertorFactory.getConvertor(WebUrlTypeConvertor.getType(origin)).convert(origin);
    }
}
