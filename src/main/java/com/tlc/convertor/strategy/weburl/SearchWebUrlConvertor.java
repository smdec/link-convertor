package com.tlc.convertor.strategy.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import com.tlc.convertor.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

/**
 * Represents deeplink Convertor
 */
@Slf4j
@Component
public class SearchWebUrlConvertor implements Convertor {
    /**
     * Method for converting deep link to web url
     *
     * @param url web url to be converted
     * @return deep link
     */
    @Override
    public String convert(String url) {
        StringSubstitutor stringSubstitutor = new StringSubstitutor(UrlUtils.extractUrlParamsAsMapDeeplink(url));
        return stringSubstitutor.replace(Constant.WEB_URL_SEARCH_TEMPLATE);
    }

    @Override
    public boolean isStrategyAcceptable(String path) {
        return path.contains(Constant.DEEP_LINK_SEARCH_PARAM);
    }
}
