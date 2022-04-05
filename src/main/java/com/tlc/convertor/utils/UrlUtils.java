package com.tlc.convertor.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        var mapParams = parseSearchWebUrl(url);
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
        var mapParams = parseSearchDetailDeeplink(url);
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

    /**
     * Method to extract parameters from url as List
     *
     * @param url string representation of URL
     * @return List <NameValuePair> with parameters of parsed query
     */
    public static List<NameValuePair> extractUrlParamsAsList(String url) throws URISyntaxException {
        return URLEncodedUtils.parse(new URI(url), StandardCharsets.UTF_8);
    }

    /**
     * Method to extract parameters from url as List
     *
     * @param url value of URL param
     * @return map of params
     */
    public Map<String, String> parseSearchWebUrl(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var list = Arrays.asList(url.split("q="));

        if (list.isEmpty()) {
            throw new IllegalArgumentException("The url size is none");
        }

        valuesMap.put("Query", list.get(1));

        return valuesMap;
    }

    /**
     * Method to extract parameters from url as List
     *
     * @param url value of URL param
     * @return map of params
     */
    public Map<String, String> parseSearchDetailDeeplink(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var list = singleSplitUrl(url, "Search&Query=");

        if (list.isEmpty()) {
            throw new IllegalArgumentException("The url size is none");
        }

        valuesMap.put("Query", list.get(1));
        return valuesMap;
    }

    /**
     * @param url value of URL param
     * @param reg value of URL param
     * @return arrays slit of url
     */
    private List<String> singleSplitUrl(String url, String reg) {
        return Arrays.asList(url.split(reg));
    }
}
