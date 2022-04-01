package com.tlc.convertor;

import com.tlc.convertor.factory.webdeeplink.DeepLinkConvertorFactory;
import com.tlc.convertor.factory.weburl.WebUrlConvertorFactory;
import com.tlc.convertor.utils.DeepLinkTypeConvertor;
import com.tlc.convertor.utils.WebUrlTypeConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Represents logic for resolving deep link strategy to be used upon conversion of web url to deep link
 */
@Component
@RequiredArgsConstructor
public class UrlConvertor {

    private final DeepLinkConvertorFactory deepLinkFactory;
    private final WebUrlConvertorFactory urlConvertorFactory;

    /**
     * Method that find strategy convert url from web-url to deeplink
     *
     * @param origin url to be converted to deep link
     * @return converted from weburl to deeplink
     */
    public String convertToDeepLink(String origin) {
        return deepLinkFactory.getConvertor(DeepLinkTypeConvertor.getType(origin)).convert(origin);
    }

    /**
     * Method that find strategy convert url from deeplink to web-url
     *
     * @param origin url to be converted to deep link
     * @return converted from deeplink to weburl
     */
    public String convertToUrl(String origin) {
        return urlConvertorFactory.getConvertor(WebUrlTypeConvertor.getType(origin)).convert(origin);
    }
}
