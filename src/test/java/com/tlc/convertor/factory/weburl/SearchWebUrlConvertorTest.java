package com.tlc.convertor.factory.weburl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchWebUrlConvertorTest {
    private final String SEARCH_URL = "ty://?Page=Search&Query=elbise";

    @Test
    void testShouldReturnWebUrl() {
        var search = new SearchWebUrlConvertor();
        assertEquals("https://www.trendyol.com/sr?q=elbise", search.convert(SEARCH_URL));
    }
}