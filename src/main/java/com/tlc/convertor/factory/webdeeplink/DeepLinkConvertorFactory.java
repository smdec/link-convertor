package com.tlc.convertor.factory.webdeeplink;

import com.tlc.convertor.enums.DeeplinkType;
import com.tlc.convertor.enums.WebUrlType;
import com.tlc.convertor.factory.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Slf4j
public class DeepLinkConvertorFactory {
    public Convertor getConvertor(DeeplinkType type) {
        return Stream.of(DeeplinkType.values())
                .filter(t -> t.name().equals(type.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type " + type))
                .getConvertor();
    }
}