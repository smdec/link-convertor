package com.tlc.convertor.factory.webdeeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;

/**
 * Represents deep link Convertor
 */
@Slf4j
public class SearchDeeplinkConvertor implements Convertor {

    /**
     * Method for converting web url to deep link
     *
     * @param url web url to be converted
     * @return deep link
     */
    @Override
    public String convert(String url) {
        StringSubstitutor stringSubstitutor = new StringSubstitutor(UrlUtils.extractUrlParamsAsMapWebUrl(url));
        return stringSubstitutor.replace(Constant.DEEPLINK_SEARCH_TEMPLATE);
    }
}
