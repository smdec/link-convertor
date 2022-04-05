package com.tlc.convertor.strategy.deeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import com.tlc.convertor.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

/**
 * Represents deep link Convertor
 */
@Slf4j
@Component
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

    @Override
    public boolean isStrategyAcceptable(String path) {
        return path.contains(Constant.WEB_URL_SEARCH_PAGE_PARAM);
    }
}
