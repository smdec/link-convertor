package com.tlc.convertor.strategy.deeplink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchDeeplinkConvertorTest {

    @Test
    void testShouldReturnDeeplink() {
        var search = new SearchDeeplinkConvertor();
        String SEARCH_URL = "https://www.trendyol.com/sr?q=elbise";
        assertEquals("ty://?Page=Search&Query=elbise", search.convert(SEARCH_URL));
    }
}