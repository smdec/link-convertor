package com.tlc.convertor.factory.weburl;

import com.tlc.convertor.enums.WebUrlType;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Represents deeplink Convertor
 */
@Component
@Slf4j
public class WebUrlConvertorFactory {
    /**
     * Method for converting deep link to web url
     *
     * @param url web url to be converted
     * @return deep link
     */
    public Convertor getConvertor(WebUrlType type) {
        return Stream.of(WebUrlType.values())
                .filter(t -> t.name().equals(type.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type " + type))
                .getConvertor();
    }
}
