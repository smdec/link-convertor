package com.tlc.convertor.strategy.weburl;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import com.tlc.convertor.utils.ParamsConfig;
import com.tlc.convertor.utils.UrlUtils;
import com.tlc.exeption.InvalidLinkException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Represents deeplink Convertor
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProductDetailWebUrlConvertor implements Convertor {
    private final ParamsConfig params;

    /**
     * Method for converting deep link to web url
     *
     * @param url web url to be converted
     * @return deep link
     */
    @Override
    public String convert(String deepLink) throws URISyntaxException {
        List<NameValuePair> nameValuePairs = UrlUtils.extractUrlParamsAsList(deepLink);
        Map<String, String> weblinks = params.getWeblinks();

        NameValuePair contentIdParam = nameValuePairs.stream()
                .filter(nameValuePair -> nameValuePair.getName().equals(Constant.DEEP_LINK_CONTENT_ID_PARAM))
                .findFirst().orElseThrow(() -> new InvalidLinkException("Link is not valid"));

        URIBuilder uriBuilder = new URIBuilder(Constant.WEB_URL_PRODUCT_PAGE + contentIdParam.getValue());

        for (NameValuePair nameValuePair : nameValuePairs) {
            if (weblinks.containsKey(nameValuePair.getName())) {
                uriBuilder.addParameter(weblinks.get(nameValuePair.getName()), nameValuePair.getValue());
            }
        }

        return uriBuilder.build().toString();
    }

    @Override
    public boolean isStrategyAcceptable(String path) {
        return path.contains(Constant.DEEP_LINK_PRODUCT_DETAIL_PARAM);
    }
}
