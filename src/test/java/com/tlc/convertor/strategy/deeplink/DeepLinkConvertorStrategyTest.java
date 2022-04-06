package com.tlc.convertor.strategy.deeplink;

import com.tlc.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("tests")
@AutoConfigureTestDatabase
class DeepLinkConvertorStrategyTest {
    @Autowired
    DeepLinkConvertorStrategy strategy;

    private final String HOME_URL = "https://www.trendyol.com/Hesabim/Favoriler";
    private final String PRODUCTION_URL = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865";
    private final String SEARCH_URL = "https://www.trendyol.com/sr?q=elbise";

    @Test
    void shouldReturnRightStatement() throws MalformedURLException {
        assertEquals(HomeDeeplinkConvertor.class, strategy.getConvertor(HOME_URL).getClass());
        assertEquals(SearchDeeplinkConvertor.class, strategy.getConvertor(SEARCH_URL).getClass());
        assertEquals(ProductDetailDeeplinkConvertor.class, strategy.getConvertor(PRODUCTION_URL).getClass());
    }
}