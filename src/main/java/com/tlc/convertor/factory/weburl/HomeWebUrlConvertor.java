package com.tlc.convertor.factory.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;

/**
 * Represents web url Convertor
 */
@Slf4j
public class HomeWebUrlConvertor implements Convertor {

    /**
     * Method for converting deep link to web url
     *
     * @param url web url to be converted
     * @return deep link
     */
    @Override
    public String convert(String url) {
        return Constant.WEB_URL_HOME_TEMPLATE;
    }
}
