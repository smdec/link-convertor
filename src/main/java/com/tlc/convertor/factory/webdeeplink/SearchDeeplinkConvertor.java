package com.tlc.convertor.factory.webdeeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.parse.UrlParser;
import org.apache.commons.text.StringSubstitutor;

public class SearchDeeplinkConvertor implements Convertor {
    @Override
    public String convert(String url) {
        var mapParams = UrlParser.parseSearchWebUrl(url);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mapParams);
        return stringSubstitutor.replace(Constant.DEEPLINK_SEARCH_TEMPLATE);
    }
}
