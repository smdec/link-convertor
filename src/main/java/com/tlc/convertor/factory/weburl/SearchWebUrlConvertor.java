package com.tlc.convertor.factory.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;

/**
 * Represents deeplink Convertor
 */
@Slf4j
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
}
