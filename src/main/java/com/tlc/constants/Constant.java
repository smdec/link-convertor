package com.tlc.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public final String CAMPAIGN_ID = "CampaignId";
    public final String BASE_DEEPLINK = "ty://?Page=Product&ContentId=";
    public final String BASE_WEB_URL = "https://www.trendyol.com/brand/name-p-";

    public final String DEEPLINK_HOME_TEMPLATE = "ty://?Page=Home";
    public final String WEB_URL_TEMPLATE = "https://www.trendyol.com";

    public final String DEEPLINK_SEARCH_TEMPLATE = "ty://?Page=Search&Query=${Query}";
    public final String WEB_URL_SEARCH_TEMPLATE = "https://www.trendyol.com/sr?q=${Query}";

    public final String WEB_URL_ONLY_CONTENT = BASE_WEB_URL.concat("${ContentId}");
    public final String WEB_URL_CONTENT_CAMPAIGN = BASE_WEB_URL.concat("${ContentId}?boutiqueId=${CampaignId}");
    public final String WEB_URL_CONTENT_MERCHANT = BASE_WEB_URL.concat("${ContentId}?merchantId=${MerchantId}");
    public final String WEB_URL_CONTENT_CAMPAIGN_MERCHANT = BASE_WEB_URL.concat("${ContentId}?boutiqueId=${CampaignId}&merchantId=${MerchantId}");

    public final String DEEPLINK_ONLY_CONTENT = BASE_DEEPLINK.concat("${ContentId}");
    public final String DEEPLINK_CONTENT_CAMPAIGN = BASE_DEEPLINK.concat("${ContentId}&CampaignId=${CampaignId}");
    public final String DEEPLINK_CONTENT_MERCHANT = BASE_DEEPLINK.concat("${ContentId}&MerchantId=${MerchantId}");
    public final String DEEPLINK_CONTENT_CAMPAIGN_MERCHANT = BASE_DEEPLINK.concat("${ContentId}&CampaignId=${CampaignId}&MerchantId=${MerchantId}");
}
