package com.tlc.convertor.strategy.deeplink;

import com.tlc.convertor.strategy.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Represents Factory for deep link converting
 */
@Component
@Slf4j
public class DeepLinkConvertorStrategy {
    private final HomeDeeplinkConvertor homeDeeplinkConvertor;
    private final ProductDetailDeeplinkConvertor productDetailDeeplinkConvertor;
    private final SearchDeeplinkConvertor searchDeeplinkConvertor;
    private final List<Convertor> strategies;

    @Autowired
    public DeepLinkConvertorStrategy(HomeDeeplinkConvertor homeDeeplinkConvertor,
                                     ProductDetailDeeplinkConvertor productDetailDeeplinkConvertor,
                                     SearchDeeplinkConvertor searchDeeplinkConvertor) {
        this.homeDeeplinkConvertor = homeDeeplinkConvertor;
        this.productDetailDeeplinkConvertor = productDetailDeeplinkConvertor;
        this.searchDeeplinkConvertor = searchDeeplinkConvertor;
        this.strategies = List.of(productDetailDeeplinkConvertor, searchDeeplinkConvertor, homeDeeplinkConvertor);
    }

    /**
     * Method for decisioning factory web url to deep link
     *
     * @param DeeplinkType type
     * @return implementation of the Convertor
     */
    public Convertor getConvertor(String url) throws MalformedURLException {
        String path = new URL(url).getPath();

        return strategies.stream()
                .filter(s -> s.isStrategyAcceptable(path))
                .findFirst()
                .orElse(homeDeeplinkConvertor);
    }
}
