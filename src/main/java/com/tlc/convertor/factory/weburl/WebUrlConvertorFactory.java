package com.tlc.convertor.factory.weburl;

import com.tlc.convertor.enums.WebUrlType;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Slf4j
public class WebUrlConvertorFactory {
    /**
     * @param WebUrlType type
     * @return implementation of the Convertor
     */
    public Convertor getConvertor(WebUrlType type) {
        return Stream.of(WebUrlType.values())
                .filter(t -> t.name().equals(type.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type " + type))
                .getConvertor();
    }
}
