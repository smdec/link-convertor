package com.tlc.convertor.strategy.deeplink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class ProductDetailDeeplinkConvertorTest {
    @Autowired
    private ProductDetailDeeplinkConvertor product;

    @Test
    void testShouldConvertRightDeeplink() throws MalformedURLException, URISyntaxException {
        String ONLY_CONTENT = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865";
        String CONTENT_CAMPAIGN = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892";
        String CONTENT_MERCHANT = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?merchantId=105064";
        String CONTENT_CAMPAIGN_MERCHANT = "https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064";

        assertEquals("ty://?Page=Product&ContentId=1925865&MerchantId=105064", product.convert(CONTENT_MERCHANT));
        assertEquals("ty://?Page=Product&ContentId=1925865&CampaignId=439892", product.convert(CONTENT_CAMPAIGN));
        assertEquals("ty://?Page=Product&ContentId=1925865", product.convert(ONLY_CONTENT));
        assertEquals("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064", product.convert(CONTENT_CAMPAIGN_MERCHANT));
    }
}