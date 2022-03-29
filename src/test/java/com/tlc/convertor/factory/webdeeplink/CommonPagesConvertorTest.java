package com.tlc.convertor.factory.webdeeplink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonPagesConvertorTest {
    private final String COMMON_URL = "https://www.trendyol.com/Hesabim/Favoriler";

    @Test
    void testShouldReturnQuery() {
        var common = new HomeLinkConvertor();
        assertEquals(common.convert(COMMON_URL), "ty://?Page=Home");
    }
}