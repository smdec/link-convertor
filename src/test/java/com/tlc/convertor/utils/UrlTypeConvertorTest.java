package com.tlc.convertor.utils;

import com.tlc.convertor.enums.UrlType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UrlTypeConvertorTest {
    private static List<String> productDetailUrls = new ArrayList<>();
    private static List<String> searchUrls = new ArrayList<>();
    private static List<String> homeUrls = new ArrayList<>();

    static {
        productDetailUrls.add("ty://?Page=Product&ContentId=1925865");
        productDetailUrls.add("ty://?Page=Product&ContentId=1925865&CampaignId=439892");
        productDetailUrls.add("ty://?Page=Product&ContentId=1925865&MerchantId=105064");
        productDetailUrls.add("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064");

        searchUrls.add("ty://?Page=Search&Query=elbise");
        searchUrls.add("ty://?Page=Search&Query=%C3%BCt%C3%BC");

        homeUrls.add("ty://?Page=Favorites");
        homeUrls.add("ty://?Page=Orders");
    }
    
    @Test
    void testShouldReturnProductDetailsType() {
        productDetailUrls.forEach(p -> assertEquals(WebUrlTypeConvertor.getType(p), UrlType.PRODUCT_DETAIL));
        productDetailUrls.forEach(p -> assertNotEquals(WebUrlTypeConvertor.getType(p), UrlType.SEARCH));
        productDetailUrls.forEach(p -> assertNotEquals(WebUrlTypeConvertor.getType(p), UrlType.HOME));
    }

    @Test
    void testShouldReturnSearchType() {
        searchUrls.forEach(p -> assertEquals(WebUrlTypeConvertor.getType(p), UrlType.SEARCH));
        searchUrls.forEach(p -> assertNotEquals(WebUrlTypeConvertor.getType(p), UrlType.PRODUCT_DETAIL));
        searchUrls.forEach(p -> assertNotEquals(WebUrlTypeConvertor.getType(p), UrlType.HOME));
    }

    @Test
    void testShouldReturnHomeType() {
        homeUrls.forEach(p -> assertEquals(WebUrlTypeConvertor.getType(p), UrlType.HOME));
        homeUrls.forEach(p -> assertNotEquals(WebUrlTypeConvertor.getType(p), UrlType.SEARCH));
        homeUrls.forEach(p -> assertNotEquals(WebUrlTypeConvertor.getType(p), UrlType.PRODUCT_DETAIL));
    }
}