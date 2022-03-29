package com.tlc.convertor.factory.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.factory.Convertor;
import com.tlc.convertor.parse.UrlParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;

@Slf4j
public class ProductDetailWebUrlConvertor implements Convertor {
    enum ProductDetailWebUrlTemplate {
        ONLY_CONTENT(Constant.WEB_URL_ONLY_CONTENT),
        CONTENT_CAMPAIGN(Constant.WEB_URL_CONTENT_CAMPAIGN),
        CONTENT_MERCHANT(Constant.WEB_URL_CONTENT_MERCHANT),
        CONTENT_CAMPAIGN_MERCHANT(Constant.WEB_URL_CONTENT_CAMPAIGN_MERCHANT);

        private final String template;

        ProductDetailWebUrlTemplate(String template) {
            this.template = template;
        }

        public String getTemplate() {
            return template;
        }
    }

    @Override
    public String convert(String url) {
        var mapParams = UrlParser.parseProductionDetailDeeplink(url);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mapParams);
        ProductDetailWebUrlTemplate template;

        switch (mapParams.size()) {
            case 1:
                template = ProductDetailWebUrlTemplate.ONLY_CONTENT;
                break;
            case 2:
                if (mapParams.containsKey(Constant.CAMPAIGN_ID)) {
                    template = ProductDetailWebUrlTemplate.CONTENT_CAMPAIGN;
                } else {
                    template = ProductDetailWebUrlTemplate.CONTENT_MERCHANT;
                }
                break;
            case 3:
                template = ProductDetailWebUrlTemplate.CONTENT_CAMPAIGN_MERCHANT;
                break;
            default:
                throw new IllegalArgumentException("Should be some exception");
        }
        return stringSubstitutor.replace(template.getTemplate());
    }
}
