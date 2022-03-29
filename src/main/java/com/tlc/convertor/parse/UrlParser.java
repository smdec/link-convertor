package com.tlc.convertor.parse;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class UrlParser {
    public Map<String, String> parseProductionDetailWebUrl(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var arr = url.split("-p-");
        if (arr.length < 1) {
            throw new IllegalArgumentException("The url size is none");
        }
        var list = multipleSplitUrl(arr[1], "?&");

        switch (list.size()) {
            case 1:
                valuesMap.put("ContentId", list.get(0));
                break;
            case 2:
                var param = Arrays.asList(list.get(1).split("="));

                valuesMap.put("ContentId", list.get(0));
                valuesMap.put(param.get(0).equals("boutiqueId") ? "CampaignId" : "MerchantId", param.get(1));
                break;
            case 3:
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

    public Map<String, String> parseProductionDetailDeeplink(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var arr = url.split("Product&");
        if (arr.length < 1) {
            throw new IllegalArgumentException("The url size is none");
        }
        var list = Arrays.asList(url.split("&"));

        switch (list.size()) {
            case 2:
                valuesMap.put("ContentId", list.get(1).split("=")[1]);
                break;
            case 3:
                var param = Arrays.asList(list.get(2).split("="));

                valuesMap.put("ContentId", list.get(1).split("=")[1]);
                valuesMap.put(param.get(0).equals("CampaignId") ? "CampaignId" : "MerchantId", param.get(1));
                break;
            case 4:
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

    public Map<String, String> parseSearchWebUrl(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var list = Arrays.asList(url.split("q="));

        if (list.isEmpty()) {
            throw new IllegalArgumentException("The url size is none");
        }

        valuesMap.put("Query",list.get(1));

        return valuesMap;
    }

    public Map<String, String> parseSearchDetailDeeplink(String url) {
        Map<String, String> valuesMap = new HashMap<>();
        var list = singleSplitUrl(url,"Search&Query=");

        if (list.isEmpty()) {
            throw new IllegalArgumentException("The url size is none");
        }

        valuesMap.put("Query",list.get(1));
        return valuesMap;
    }

    private List<String> multipleSplitUrl(String url, String reg) {
        return Arrays.asList(StringUtils.split(url, reg));
    }

    private List<String> singleSplitUrl(String url, String reg) {
        return Arrays.asList(url.split(reg));
    }
}
