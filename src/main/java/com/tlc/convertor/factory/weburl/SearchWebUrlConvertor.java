package com.tlc.convertor.factory.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.parse.UrlParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;

@Slf4j
public class SearchWebUrlConvertor implements Convertor {
    @Override
    public String convert(String url) {
        var mapParams = UrlParser.parseSearchDetailDeeplink(url);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mapParams);
        return stringSubstitutor.replace(Constant.WEB_URL_SEARCH_TEMPLATE);
    }
}
