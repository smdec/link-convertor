package com.tlc.convertor.factory.webdeeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeDeeplinkConvertor implements Convertor {
    @Override
    public String convert(String url) {
        return Constant.DEEPLINK_HOME_TEMPLATE;
    }
}
