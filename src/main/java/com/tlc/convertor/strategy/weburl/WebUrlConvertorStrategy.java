package com.tlc.convertor.strategy.weburl;

import com.tlc.convertor.strategy.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Represents deeplink Convertor
 */
@Component
@Slf4j
public class WebUrlConvertorStrategy {
    private final HomeWebUrlConvertor homeWebUrlConvertor;
    private final ProductDetailWebUrlConvertor productDetailWebUrlConvertor;
    private final SearchWebUrlConvertor searchWebUrlConvertor;
    private final List<Convertor> strategies;

    @Autowired
    public WebUrlConvertorStrategy(HomeWebUrlConvertor homeWebUrlConvertor,
                                   ProductDetailWebUrlConvertor productDetailWebUrlConvertor,
                                   SearchWebUrlConvertor searchWebUrlConvertor) {
        this.homeWebUrlConvertor = homeWebUrlConvertor;
        this.productDetailWebUrlConvertor = productDetailWebUrlConvertor;
        this.searchWebUrlConvertor = searchWebUrlConvertor;
        this.strategies = List.of(this.productDetailWebUrlConvertor, this.searchWebUrlConvertor, this.homeWebUrlConvertor);
    }

    /**
     * Method for converting deep link to web url
     *
     * @param url web url to be converted
     * @return deep link
     */
    public Convertor getConvertor(String url) throws MalformedURLException {

        return strategies.stream()
                .filter(s -> s.isStrategyAcceptable(url))
                .findFirst()
                .orElse(homeWebUrlConvertor);
    }
}
