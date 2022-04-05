package com.tlc.convertor.strategy.deeplink;

import com.tlc.constants.Constant;
import com.tlc.convertor.strategy.Convertor;
import com.tlc.convertor.utils.ParamsConfig;
import com.tlc.convertor.utils.UrlUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Represents deep link Convertor
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProductDetailDeeplinkConvertor implements Convertor {
    private final ParamsConfig params;

    @Override
    public String convert(String url) throws MalformedURLException, URISyntaxException {
        String path = new URL(url).getPath();
        String productId = new URL(url).getPath().substring(path.lastIndexOf("-") + 1);

        List<NameValuePair> nameValuePairs = UrlUtils.extractUrlParamsAsList(url);
        nameValuePairs.add(0, new BasicNameValuePair(Constant.WEB_URL_PRODUCT_ID_PARAM, productId));
        nameValuePairs.add(0, new BasicNameValuePair(Constant.DEEP_LINK_PAGE_PARAM, Constant.DEEP_LINK_PAGE_PARAM_VALUE));

        URIBuilder webUrlUri = new URIBuilder().setScheme(Constant.DEEP_LINK_HOST).setHost("");

        Map<String, String> deeplinksParams = params.getDeeplinks();
        for (NameValuePair nameValuePair : nameValuePairs) {
            if (deeplinksParams.containsKey(nameValuePair.getName())) {
                webUrlUri.addParameter(deeplinksParams.get(nameValuePair.getName()), nameValuePair.getValue());
            }
        }

        return webUrlUri.toString();
    }

    @Override
    public boolean isStrategyAcceptable(String path) {
        return path.contains(Constant.WEB_URL_PRODUCT_DETAIL_PARAM);
    }
}
