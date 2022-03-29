package com.tlc.convertor.parse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlParserTest {
    private final String ONLY_CONTENT_WEB_URL = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865";
    private final String CONTENT_CAMPAIGN_WEB_URL = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892";
    private final String CONTENT_MERCHANT_WEB_URL = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?merchantId=105064";
    private final String CONTENT_CAMPAIGN_MERCHANT_WEB_URL = "https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064";

    private final String ONLY_CONTENT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865";
    private final String CONTENT_CAMPAIGN_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&CampaignId=439892";
    private final String CONTENT_MERCHANT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&MerchantId=105064";
    private final String CONTENT_CAMPAIGN_MERCHANT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064";

    private final String SEARCH_DEEPLINK_URL = "ty://?Page=Search&Query=elbise";
    private final String SEARCH_WEB_URL = "https://www.trendyol.com/sr?q=elbise";

    @Test
    void testShouldReturnOnlyContentIdForWebUrl() {
        var map = UrlParser.parseProductionDetailDeeplink(ONLY_CONTENT_DEEPLINK_URL);
        assertEquals(map.get("ContentId"), "1925865");
    }

    @Test
    void testShouldReturnOnlyContentIdAndCampaignIdForWebUrl() {
        var map = UrlParser.parseProductionDetailDeeplink(CONTENT_CAMPAIGN_DEEPLINK_URL);
        assertEquals(map.get("ContentId"), "1925865");
        assertEquals(map.get("CampaignId"), "439892");
    }

    @Test
    void testShouldReturnOnlyContentIdAndMerchantIdForWebUrl() {
        var map = UrlParser.parseProductionDetailDeeplink(CONTENT_MERCHANT_DEEPLINK_URL);
        assertEquals(map.get("ContentId"), "1925865");
        assertEquals(map.get("MerchantId"), "105064");
    }

    @Test
    void testShouldReturnOnlyContentIdAndCampaignIdAndMerchantIdForWebUrl() {
        var map = UrlParser.parseProductionDetailDeeplink(CONTENT_CAMPAIGN_MERCHANT_DEEPLINK_URL);
        assertEquals(map.get("ContentId"), "1925865");
        assertEquals(map.get("CampaignId"), "439892");
        assertEquals(map.get("MerchantId"), "105064");
    }

    @Test
    void testShouldReturnOnlyContentIdForDeeplink() {
        var map = UrlParser.parseProductionDetailWebUrl(ONLY_CONTENT_WEB_URL);
        assertEquals(map.get("ContentId"), "1925865");
    }

    @Test
    void testShouldReturnOnlyContentIdAndCampaignIdForDeeplink() {
        var map = UrlParser.parseProductionDetailWebUrl(CONTENT_CAMPAIGN_WEB_URL);
        assertEquals(map.get("ContentId"), "1925865");
        assertEquals(map.get("CampaignId"), "439892");
    }

    @Test
    void testShouldReturnOnlyContentIdAndMerchantIdForDeeplink() {
        var map = UrlParser.parseProductionDetailWebUrl(CONTENT_MERCHANT_WEB_URL);
        assertEquals(map.get("ContentId"), "1925865");
        assertEquals(map.get("MerchantId"), "105064");
    }

    @Test
    void testShouldReturnOnlyContentIdAndCampaignIdAndMerchantIdForDeeplink() {
        var map = UrlParser.parseProductionDetailWebUrl(CONTENT_CAMPAIGN_MERCHANT_WEB_URL);
        assertEquals(map.get("ContentId"), "1925865");
        assertEquals(map.get("CampaignId"), "439892");
        assertEquals(map.get("MerchantId"), "105064");
    }

    @Test
    void testShouldReturnDeeplinkQuery() {
        var map = UrlParser.parseSearchDetailDeeplink(SEARCH_DEEPLINK_URL);
        assertEquals(map.get("Query"), "elbise");
    }

    @Test
    void testShouldReturnWebUrlQuery() {
        var map = UrlParser.parseSearchWebUrl(SEARCH_WEB_URL);
        assertEquals(map.get("Query"), "elbise");
    }
}