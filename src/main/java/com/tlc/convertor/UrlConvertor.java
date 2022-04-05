package com.tlc.convertor;

import com.tlc.convertor.strategy.deeplink.DeepLinkConvertorStrategy;
import com.tlc.convertor.strategy.weburl.WebUrlConvertorStrategy;
import com.tlc.exeption.InvalidLinkException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

/**
 * Represents logic for resolving deep link strategy to be used upon conversion of web url to deep link
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UrlConvertor {

    private final DeepLinkConvertorStrategy deepLinkFactory;
    private final WebUrlConvertorStrategy urlConvertorFactory;

    /**
     * Method that find strategy convert url from web-url to deeplink
     *
     * @param origin url to be converted to deep link
     * @return converted from weburl to deeplink
     */
    public String convertToDeepLink(String origin) {
        try {
            return deepLinkFactory.getConvertor(origin).convert(origin);
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            throw new InvalidLinkException(e.getMessage());
        }
    }

    /**
     * Method that find strategy convert url from deeplink to web-url
     *
     * @param origin url to be converted to deep link
     * @return converted from deeplink to weburl
     */
    public String convertToUrl(String origin) {
        try {
            return urlConvertorFactory.getConvertor(origin).convert(origin);
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            throw new InvalidLinkException(e.getMessage());
        }
    }
}
