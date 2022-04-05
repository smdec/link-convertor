package com.tlc.convertor.strategy.weburl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWebUrlConvertorTest {
    private final String HOME_URL = "ty://?Page=Favorites";

    @Test
    void testShouldReturnWebUrl() {
        var search = new HomeWebUrlConvertor();
        assertEquals("https://www.trendyol.com", search.convert(HOME_URL));
    }
}