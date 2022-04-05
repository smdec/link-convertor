package com.tlc.convertor.strategy.deeplink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePagesConvertorTest {
    private final String HOME_URL = "https://www.trendyol.com/Hesabim/Favoriler";

    @Test
    void testShouldReturnQuery() {
        var common = new HomeDeeplinkConvertor();
        assertEquals(common.convert(HOME_URL), "ty://?Page=Home");
    }
}