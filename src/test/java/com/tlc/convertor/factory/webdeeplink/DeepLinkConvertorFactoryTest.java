package com.tlc.convertor.factory.webdeeplink;

import com.tlc.convertor.enums.DeeplinkType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DeepLinkConvertorFactoryTest {
    @Autowired
    DeepLinkConvertorFactory factory;

    @Test
    void shouldReturnRightStatement() {
        assertEquals(ProductDetailDeeplinkConvertor.class, factory.getConvertor(DeeplinkType.PRODUCT_DETAIL).getClass());
        assertEquals(SearchDeeplinkConvertor.class, factory.getConvertor(DeeplinkType.SEARCH).getClass());
        assertEquals(HomeDeeplinkConvertor.class, factory.getConvertor(DeeplinkType.HOME).getClass());
    }
}