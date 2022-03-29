package com.tlc.convertor.factory.webdeeplink;

import com.tlc.convertor.parse.UrlParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDetailDeeplinkConvertorTest {
    private final String ONLY_CONTENT = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865";
    private final String CONTENT_CAMPAIGN = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892";
    private final String CONTENT_MERCHANT = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?merchantId=105064";
    private final String CONTENT_CAMPAIGN_MERCHANT = "https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064";

    private final ProductDetailDeeplinkConvertor product = new ProductDetailDeeplinkConvertor();

    @Test
    void testShouldConvertRightDeeplink() {
        assertEquals("ty://?Page=Product&ContentId=1925865", product.convert(ONLY_CONTENT));
        assertEquals("ty://?Page=Product&ContentId=1925865&CampaignId=439892", product.convert(CONTENT_CAMPAIGN));
        assertEquals("ty://?Page=Product&ContentId=1925865&MerchantId=105064", product.convert(CONTENT_MERCHANT));
        assertEquals("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064", product.convert(CONTENT_CAMPAIGN_MERCHANT));
    }
}