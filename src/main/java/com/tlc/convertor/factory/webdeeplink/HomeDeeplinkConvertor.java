package com.tlc.convertor.factory.webdeeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;

/**
 * Represents deep link Convertor
 */
@Slf4j
public class HomeDeeplinkConvertor implements Convertor {

    /**
     * Method for converting web url to deep link
     *
     * @param url web url to be converted
     * @return deep link
     */
    @Override
    public String convert(String url) {
        return Constant.DEEPLINK_HOME_TEMPLATE;
    }
}
