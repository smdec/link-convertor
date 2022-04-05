package com.tlc.convertor.strategy.deeplink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePagesConvertorTest {

    @Test
    void testShouldReturnQuery() {
        var common = new HomeDeeplinkConvertor();
        String HOME_URL = "https://www.trendyol.com/Hesabim/Favoriler";
        assertEquals("ty://?Page=Home", common.convert(HOME_URL));
    }
}