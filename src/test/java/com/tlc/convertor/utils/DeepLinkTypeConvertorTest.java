package com.tlc.convertor.utils;

import com.tlc.convertor.enums.DeeplinkType;
import com.tlc.convertor.enums.WebUrlType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeepLinkTypeConvertorTest {
    private static List<String> productDetailUrls = new ArrayList<>();
    private static List<String> searchUrls = new ArrayList<>();
    private static List<String> homeUrls = new ArrayList<>();

    static {
        productDetailUrls.add("https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064");
        productDetailUrls.add("https://www.trendyol.com/casio/mtp-1374d-2avdf-erkek-kol-saati-celik-p-1925865");
        productDetailUrls.add("https://www.trendyol.com/casio/mtp-1374d-2avdf-erkek-kol-saati-celik-p-1925865?merchantId=105064");

        searchUrls.add("https://www.trendyol.com/sr?q=elbise");
        searchUrls.add("https://www.trendyol.com/sr?q=%C3%BCt%C3%BC");

        homeUrls.add("https://www.trendyol.com/Hesabim/Favoriler");
        homeUrls.add("https://www.trendyol.com/Hesabim/#/Siparislerim");
    }

    @Test
    void testShouldReturnProductDetailsType() {
        productDetailUrls.forEach(p -> assertEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.PRODUCT_DETAIL));
        productDetailUrls.forEach(p -> assertNotEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.SEARCH));
        productDetailUrls.forEach(p -> assertNotEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.HOME));
    }

    @Test
    void testShouldReturnSearchType() {
        searchUrls.forEach(p -> assertEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.SEARCH));
        searchUrls.forEach(p -> assertNotEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.PRODUCT_DETAIL));
        searchUrls.forEach(p -> assertNotEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.HOME));
    }

    @Test
    void testShouldReturnHomeType() {
        homeUrls.forEach(p -> assertEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.HOME));
        homeUrls.forEach(p -> assertNotEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.SEARCH));
        homeUrls.forEach(p -> assertNotEquals(DeepLinkTypeConvertor.getType(p), DeeplinkType.PRODUCT_DETAIL));
    }
}