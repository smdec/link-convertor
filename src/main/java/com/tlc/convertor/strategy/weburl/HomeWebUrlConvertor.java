package com.tlc.convertor.strategy.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Represents web url Convertor
 */
@Slf4j
@Component
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

    @Override
    public boolean isStrategyAcceptable(String path) {
        return true;
    }
}
