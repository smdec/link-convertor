package com.tlc.convertor.utils;

import com.tlc.convertor.parse.UrlParser;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@UtilityClass
@Slf4j
public class UrlUtils {
    /**
     * Method to extract parameters from url as Map for WebUrl
     *
     * @param url string representation of URL
     * @return Map <String, String> with parameters of parsed query
     */
    public static Map<String, String> extractUrlParamsAsMapWebUrl(String url) {
        var mapParams = UrlParser.parseSearchWebUrl(url);
        mapParams.forEach((key, value) -> {
            try {
                UrlUtils.encodeValue(value);
            } catch (UnsupportedEncodingException e) {
                log.error(String.format("Error during convert: %s", e.getMessage()));
            }
        });
        return mapParams;
    }

    /**
     * Method to extract parameters from url as Map for Deeplink
     *
     * @param url string representation of URL
     * @return Map <String, String> with parameters of parsed query
     */
    public static Map<String, String> extractUrlParamsAsMapDeeplink(String url) {
        var mapParams = UrlParser.parseSearchDetailDeeplink(url);
        mapParams.forEach((key, value) -> {
            try {
                UrlUtils.encodeValue(value);
            } catch (UnsupportedEncodingException e) {
                log.error(String.format("Error during convert: %s", e.getMessage()));
            }
        });
        return mapParams;
    }

    /**
     * Method for url encode query value
     *
     * @param value value of URL param
     * @return encoded value
     */
    public static String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }
}
