package com.tlc.convertor.factory.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeWebUrlConvertor implements Convertor {
    @Override
    public String convert(String url) {
        return Constant.WEB_URL_HOME_TEMPLATE;
    }
}
