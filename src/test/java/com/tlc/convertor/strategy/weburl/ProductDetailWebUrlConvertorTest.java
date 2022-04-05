package com.tlc.convertor.strategy.weburl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class ProductDetailWebUrlConvertorTest {
    @Autowired
    private ProductDetailWebUrlConvertor product;

    @Test
    void testShouldConvertRightDeeplink() throws URISyntaxException {
        var ONLY_CONTENT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865";
        var CONTENT_CAMPAIGN_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&CampaignId=439892";
        var CONTENT_MERCHANT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&MerchantId=105064";
        var CONTENT_CAMPAIGN_MERCHANT_DEEPLINK_URL = "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064";

        var ONLY_CONTENT_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865";
        var CONTENT_CAMPAIGN_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892";
        var CONTENT_MERCHANT_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865?merchantId=105064";
        var CONTENT_CAMPAIGN_MERCHANT_WEB_URL = "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892&merchantId=105064";

        assertEquals(ONLY_CONTENT_WEB_URL, product.convert(ONLY_CONTENT_DEEPLINK_URL));
        assertEquals(CONTENT_CAMPAIGN_WEB_URL, product.convert(CONTENT_CAMPAIGN_DEEPLINK_URL));
        assertEquals(CONTENT_MERCHANT_WEB_URL, product.convert(CONTENT_MERCHANT_DEEPLINK_URL));
        assertEquals(CONTENT_CAMPAIGN_MERCHANT_WEB_URL, product.convert(CONTENT_CAMPAIGN_MERCHANT_DEEPLINK_URL));
    }
}