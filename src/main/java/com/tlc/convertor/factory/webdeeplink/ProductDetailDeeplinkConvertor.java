package com.tlc.convertor.factory.webdeeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.parse.UrlParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;

@Slf4j
public class ProductDetailDeeplinkConvertor implements Convertor {
    enum ProductDetailDeeplinkTemplate {
        ONLY_CONTENT(Constant.DEEPLINK_ONLY_CONTENT),
        CONTENT_CAMPAIGN(Constant.DEEPLINK_CONTENT_CAMPAIGN),
        CONTENT_MERCHANT(Constant.DEEPLINK_CONTENT_MERCHANT),
        CONTENT_CAMPAIGN_MERCHANT(Constant.DEEPLINK_CONTENT_CAMPAIGN_MERCHANT);

        private final String template;

        ProductDetailDeeplinkTemplate(String template) {
            this.template = template;
        }

        public String getTemplate() {
            return template;
        }
    }

    @Override
    public String convert(String url) {
        var mapParams = UrlParser.parseProductionDetailWebUrl(url);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mapParams);
        ProductDetailDeeplinkTemplate template;

        switch (mapParams.size()) {
            case 1:
                template = ProductDetailDeeplinkTemplate.ONLY_CONTENT;
                break;
            case 2:
                if (mapParams.containsKey(Constant.CAMPAIGN_ID)) {
                    template = ProductDetailDeeplinkTemplate.CONTENT_CAMPAIGN;
                } else {
                    template = ProductDetailDeeplinkTemplate.CONTENT_MERCHANT;
                }
                break;
            case 3:
                template = ProductDetailDeeplinkTemplate.CONTENT_CAMPAIGN_MERCHANT;
                break;
            default:
                throw new IllegalArgumentException("Should be some exception");
        }
        return stringSubstitutor.replace(template.getTemplate());
    }
}
