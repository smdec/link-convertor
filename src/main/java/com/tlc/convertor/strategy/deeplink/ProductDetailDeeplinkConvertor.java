package com.tlc.convertor.strategy.deeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import com.tlc.convertor.parse.UrlParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Represents deep link Convertor
 */
@Slf4j
@Component
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

    /**
     * Method for converting web url to deep link
     *
     * @param url web url to be converted
     * @return deep link
     */
    @Override
    public String convert(String url) {
        var mapParams = UrlParser.parseProductionDetailWebUrl(url);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(mapParams);
        ProductDetailDeeplinkTemplate template;

        switch (Objects.requireNonNull(mapParams).size()) {
            case Constant.ONE:
                template = ProductDetailDeeplinkTemplate.ONLY_CONTENT;
                break;
            case Constant.TWO:
                if (mapParams.containsKey(Constant.CAMPAIGN_ID)) {
                    template = ProductDetailDeeplinkTemplate.CONTENT_CAMPAIGN;
                } else {
                    template = ProductDetailDeeplinkTemplate.CONTENT_MERCHANT;
                }
                break;
            case Constant.THREE:
                template = ProductDetailDeeplinkTemplate.CONTENT_CAMPAIGN_MERCHANT;
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Product detail webUrl template not found url: %s", url));
        }
        return stringSubstitutor.replace(template.getTemplate());
    }

    @Override
    public boolean isStrategyAcceptable(String path) {
        return path.contains(Constant.WEB_URL_PRODUCT_DETAIL_PARAM);
    }
}
