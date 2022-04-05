package com.tlc.convertor.strategy.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import com.tlc.convertor.parse.UrlParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

/**
 * Represents deeplink Convertor
 */
@Slf4j
@Component
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

    /**
     * Method for converting deep link to web url
     *
     * @param url web url to be converted
     * @return deep link
     */
    @Override
    public String convert(String url) {
        var mapParams = UrlParser.parseProductionDetailDeeplink(url);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mapParams);
        ProductDetailWebUrlTemplate template;

        switch (mapParams.size()) {
            case Constant.ONE:
                template = ProductDetailWebUrlTemplate.ONLY_CONTENT;
                break;
            case Constant.TWO:
                if (mapParams.containsKey(Constant.CAMPAIGN_ID)) {
                    template = ProductDetailWebUrlTemplate.CONTENT_CAMPAIGN;
                } else {
                    template = ProductDetailWebUrlTemplate.CONTENT_MERCHANT;
                }
                break;
            case Constant.THREE:
                template = ProductDetailWebUrlTemplate.CONTENT_CAMPAIGN_MERCHANT;
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Product detail webUrl template not found url: %s", url));
        }
        return stringSubstitutor.replace(template.getTemplate());
    }

    @Override
    public boolean isStrategyAcceptable(String path) {
        return path.contains(Constant.DEEP_LINK_PRODUCT_DETAIL_PARAM);
    }
}
