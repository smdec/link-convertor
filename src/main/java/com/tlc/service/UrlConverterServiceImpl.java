package com.tlc.service;

import com.tlc.convertor.UrlConvertor;
import com.tlc.dto.UrlDtoRequest;
import com.tlc.dto.DeepLinkResponse;
import com.tlc.dto.WebUrlResponse;
import com.tlc.mapper.DeeplinkEntityMapper;
import com.tlc.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * Service with logic for check existing already converted links and creating new one if not exists
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UrlConverterServiceImpl implements UrlConverterService {
    private final UrlRepository repository;
    private final UrlConvertor convertor;
    private final DeeplinkEntityMapper mapper;

    /**
     * Method for converting between web url and deep link
     * Uses database for checking previously converted links
     *
     * @param webUrl contains actual link to be converted
     * @return UrlDTO object with converted link
     */
    @Override
    public DeepLinkResponse urlToDeeplink(@NonNull UrlDtoRequest webUrl) {
        var cashDeeplink = repository.findByUrl(webUrl.getUrl());
        if (cashDeeplink.isPresent()) {
            return mapper.toDeepLinkResponse(repository.save(cashDeeplink.get()));
        }

        log.debug("Start converting from webUrl to deeplink webUrl: {}", webUrl);
        var entity = mapper.toEntity(webUrl);
        entity.setDeepLink(convertor.convertToDeepLink(entity.getUrl()));
        log.debug("Result of converting webUrl to deeplink entity: {}", entity);
        return mapper.toDeepLinkResponse(repository.save(entity));
    }

    /**
     * Method for converting between deep link and web url
     *
     * @param deeplink contains actual link to be converted
     * @return UrlDTO object with converted link
     */
    @Override
    public WebUrlResponse deeplinkToUrl(@NonNull UrlDtoRequest deeplink) {
        var cashDeeplink = repository.findByDeepLink(deeplink.getUrl());
        if (cashDeeplink.isPresent()) {
            return mapper.toWebUrlResponse(repository.save(cashDeeplink.get()));
        }

        log.debug("Start converting from deeplink to deeplink: {}", deeplink);
        var entity = mapper.toEntity(deeplink);
        entity.setUrl(convertor.convertToUrl(entity.getDeepLink()));
        log.debug("Result of converting from webUrl to entity: {}", entity);
        return mapper.toWebUrlResponse(repository.save(entity));
    }
}
