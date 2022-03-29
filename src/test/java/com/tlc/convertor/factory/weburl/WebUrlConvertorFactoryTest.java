package com.tlc.convertor.factory.weburl;

import com.tlc.convertor.enums.WebUrlType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WebUrlConvertorFactoryTest {
    @Autowired
    WebUrlConvertorFactory factory;

    @Test
    void shouldReturnRightStatement() {
        assertEquals(ProductDetailWebUrlConvertor.class, factory.getConvertor(WebUrlType.PRODUCT_DETAIL).getClass());
        assertEquals(SearchWebUrlConvertor.class, factory.getConvertor(WebUrlType.SEARCH).getClass());
        assertEquals(HomeWebUrlConvertor.class, factory.getConvertor(WebUrlType.HOME).getClass());
    }
}