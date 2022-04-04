package com.tlc.service;

import com.tlc.convertor.UrlConvertor;
import com.tlc.dto.DeepLinkResponse;
import com.tlc.dto.UrlDtoRequest;
import com.tlc.dto.WebUrlResponse;
import com.tlc.mapper.DeeplinkEntityMapper;
import com.tlc.model.UrlEntity;
import com.tlc.repository.UrlRepository;
import com.tlc.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UrlConverterServiceTest {
    @Mock
    private UrlRepository repository;
    @Mock
    private DeeplinkEntityMapper mapper;
    @Mock
    private UrlConvertor urlConvertor;
    @InjectMocks
    private UrlConverterServiceImpl service;

    @Test
    void urlToDeeplink_cacheFlow() {
        var webUrl = TestUtil.nextObject(UrlDtoRequest.class);
        var deeplink = TestUtil.nextObject(DeepLinkResponse.class);
        var entity = new UrlEntity(1L, webUrl.getUrl(), deeplink.getUrl());

        when(repository.findByUrl(webUrl.getUrl())).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDeepLinkResponse(entity)).thenReturn(deeplink);

        var res = service.urlToDeeplink(webUrl);
        assertEquals(deeplink.getUrl(), res.getUrl());
    }

    @Test
    void urlToDeeplink_noCacheFlow() {
        var webUrl = TestUtil.nextObject(UrlDtoRequest.class);
        var deeplink = TestUtil.nextObject(DeepLinkResponse.class);
        var entity = new UrlEntity(1L, webUrl.getUrl(), deeplink.getUrl());

        when(repository.findByUrl(webUrl.getUrl())).thenReturn(Optional.empty());
        when(mapper.toEntity(webUrl)).thenReturn(entity);
        when(urlConvertor.convertToDeepLink(entity.getUrl())).thenReturn(entity.getDeepLink());

        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDeepLinkResponse(entity)).thenReturn(deeplink);

        var res = service.urlToDeeplink(webUrl);
        assertEquals(deeplink.getUrl(), res.getUrl());
    }

    @Test
    void deeplinkToUrl_cacheFlow() {
        var deeplink = TestUtil.nextObject(UrlDtoRequest.class);
        var webUrl = TestUtil.nextObject(WebUrlResponse.class);
        var entity = new UrlEntity(1L, webUrl.getUrl(), deeplink.getUrl());

        when(repository.findByDeepLink(deeplink.getUrl())).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toWebUrlResponse(entity)).thenReturn(webUrl);

        var res = service.deeplinkToUrl(deeplink);
        assertEquals(webUrl.getUrl(), res.getUrl());
    }

    @Test
    void deeplinkToUrl_noCacheFlow() {
        var deeplink = TestUtil.nextObject(UrlDtoRequest.class);
        var webUrl = TestUtil.nextObject(WebUrlResponse.class);
        var entity = new UrlEntity(1L, webUrl.getUrl(), deeplink.getUrl());

        when(repository.findByDeepLink(deeplink.getUrl())).thenReturn(Optional.empty());
        when(mapper.toEntity(deeplink)).thenReturn(entity);
        when(urlConvertor.convertToUrl(entity.getDeepLink())).thenReturn(entity.getUrl());
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toWebUrlResponse(entity)).thenReturn(webUrl);

        var res = service.deeplinkToUrl(deeplink);
        assertEquals(webUrl.getUrl(), res.getUrl());
    }
}