package com.tlc.convertor.strategy.deeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Represents deep link Convertor
 */
@Slf4j
@Component
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

    @Override
    public boolean isStrategyAcceptable(String path) {
        return true;
    }
}
