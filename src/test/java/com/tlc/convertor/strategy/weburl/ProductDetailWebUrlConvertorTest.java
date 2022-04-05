package com.tlc.convertor.strategy.weburl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDetailWebUrlConvertorTest {
    private final String ONLY_CONTENT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865";
    private final String CONTENT_CAMPAIGN_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&CampaignId=439892";
    private final String CONTENT_MERCHANT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&MerchantId=105064";
    private final String CONTENT_CAMPAIGN_MERCHANT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064";

    private final String ONLY_CONTENT_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865";
    private final String CONTENT_CAMPAIGN_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892";
    private final String CONTENT_MERCHANT_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865?merchantId=105064";
    private final String CONTENT_CAMPAIGN_MERCHANT_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892&merchantId=105064";

    private final ProductDetailWebUrlConvertor product = new ProductDetailWebUrlConvertor();

    @Test
    void testShouldConvertRightDeeplink() {
        assertEquals(ONLY_CONTENT_WEB_URL, product.convert(ONLY_CONTENT_DEEPLINK_URL));
        assertEquals(CONTENT_CAMPAIGN_WEB_URL, product.convert(CONTENT_CAMPAIGN_DEEPLINK_URL));
        assertEquals(CONTENT_MERCHANT_WEB_URL, product.convert(CONTENT_MERCHANT_DEEPLINK_URL));
        assertEquals(CONTENT_CAMPAIGN_MERCHANT_WEB_URL, product.convert(CONTENT_CAMPAIGN_MERCHANT_DEEPLINK_URL));
    }
}