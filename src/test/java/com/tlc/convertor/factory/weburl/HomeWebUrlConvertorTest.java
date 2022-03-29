package com.tlc.convertor.factory.weburl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWebUrlConvertorTest {
    private final String SEARCH_URL = "ty://?Page=Favorites";

    @Test
    void testShouldReturnWebUrl() {
        var search = new HomeWebUrlConvertor();
        assertEquals("https://www.trendyol.com", search.convert(SEARCH_URL));
    }
}