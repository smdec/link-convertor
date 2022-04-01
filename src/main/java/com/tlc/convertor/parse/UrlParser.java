package com.tlc.convertor.parse;

import com.tlc.constants.Constant;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Util helper class with methods for working with url data
 */
@UtilityClass
public class UrlParser {
    /**
     * Method to extract parameters from url as List
     *
     * @param url value of URL param
     * @return map of params
     */
    public Map<String, String> parseProductionDetailWebUrl(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var arr = url.split("-p-");
        if (arr.length < Constant.ONE) {
            throw new IllegalArgumentException("The url size is none");
        }
        var list = multipleSplitUrl(arr[1], "?&");

        switch (list.size()) {
            case Constant.ONE:
                valuesMap.put("ContentId", list.get(0));
                break;
            case Constant.TWO:
                var param = Arrays.asList(list.get(1).split("="));

                valuesMap.put("ContentId", list.get(0));
                valuesMap.put(param.get(0).equals("boutiqueId") ? "CampaignId" : "MerchantId", param.get(1));
                break;
            case Constant.THREE:
                var firstParam = Arrays.asList(list.get(1).split("="));
                var secondParam = Arrays.asList(list.get(2).split("="));

                valuesMap.put("ContentId", list.get(0));
                valuesMap.put(firstParam.get(0).equals("boutiqueId") ? "CampaignId" : "MerchantId", firstParam.get(1));
                valuesMap.put(secondParam.get(0).equals("boutiqueId") ? "CampaignId" : "MerchantId", secondParam.get(1));
                break;
            default:
                throw new IllegalArgumentException("The url size is none");
        }
        return valuesMap;
    }

    /**
     * Method to extract parameters from url as List
     *
     * @param url value of URL param
     * @return map of params
     */
    public Map<String, String> parseProductionDetailDeeplink(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var arr = url.split("Product&");
        if (arr.length < Constant.ONE) {
            throw new IllegalArgumentException("The url size is none");
        }
        var list = Arrays.asList(url.split("&"));

        switch (list.size()) {
            case Constant.TWO:
                valuesMap.put("ContentId", list.get(1).split("=")[1]);
                break;
            case Constant.THREE:
                var param = Arrays.asList(list.get(2).split("="));

                valuesMap.put("ContentId", list.get(1).split("=")[1]);
                valuesMap.put(param.get(0).equals("CampaignId") ? "CampaignId" : "MerchantId", param.get(1));
                break;
            case Constant.FOUR:
                var firstParam = Arrays.asList(list.get(2).split("="));
                var secondParam = Arrays.asList(list.get(3).split("="));

                valuesMap.put("ContentId", list.get(1).split("=")[1]);
                valuesMap.put(firstParam.get(0).equals("CampaignId") ? "CampaignId" : "MerchantId", firstParam.get(1));
                valuesMap.put(secondParam.get(0).equals("CampaignId") ? "CampaignId" : "MerchantId", secondParam.get(1));
                break;
            default:
                throw new IllegalArgumentException("The url size is none");
        }

        return valuesMap;
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
    private List<String> multipleSplitUrl(String url, String reg) {
        return Arrays.asList(StringUtils.split(url, reg));
    }

    /**
     * @param url value of URL param
     * @param reg value of URL param
     * @return arrays slit of url
     */
    private List<String> singleSplitUrl(String url, String reg) {
        return Arrays.asList(url.split(reg));
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
