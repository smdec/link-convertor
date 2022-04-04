package com.tlc.convertor.utils;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class UrlUtilsTest {
    private static final String TURKISH_STRING = "ütü";
    private static final String TURKISH_ENCODED_STRING = "%C3%BCt%C3%BC";

    @Test
    void encodeValueTest() throws UnsupportedEncodingException {
        String encodedValue = UrlUtils.encodeValue(TURKISH_STRING);
        assertEquals(TURKISH_ENCODED_STRING, encodedValue);
    }
}