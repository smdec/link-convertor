package com.tlc.convertor.strategy.weburl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("tests")
@AutoConfigureTestDatabase
class WebUrlConvertorStrategyTest {
    @Autowired
    WebUrlConvertorStrategy factory;

    private final String ONLY_CONTENT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865";
    private final String SEARCH_URL = "ty://?Page=Search&Query=elbise";
    private final String HOME_URL = "ty://?Page=Favorites";

    @Test
    void shouldReturnRightStatement() throws MalformedURLException {
        assertEquals(ProductDetailWebUrlConvertor.class, factory.getConvertor(ONLY_CONTENT_DEEPLINK_URL).getClass());
        assertEquals(SearchWebUrlConvertor.class, factory.getConvertor(SEARCH_URL).getClass());
        assertEquals(HomeWebUrlConvertor.class, factory.getConvertor(HOME_URL).getClass());
    }
}