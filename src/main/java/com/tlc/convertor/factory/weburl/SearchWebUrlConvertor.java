package com.tlc.convertor.factory.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.parse.UrlParser;
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
        var mapParams = UrlParser.parseSearchDetailDeeplink(url);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mapParams);
        return stringSubstitutor.replace(Constant.WEB_URL_SEARCH_TEMPLATE);
    }
}
