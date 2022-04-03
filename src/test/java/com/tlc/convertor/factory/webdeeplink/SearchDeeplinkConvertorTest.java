package com.tlc.convertor.factory.webdeeplink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchDeeplinkConvertorTest {
    private final String SEARCH_URL = "https://www.trendyol.com/sr?q=elbise";

    @Test
    void testShouldReturnDeeplink() {
        var search = new SearchDeeplinkConvertor();
        assertEquals(search.convert(SEARCH_URL), "ty://?Page=Search&Query=elbise");
    }
}