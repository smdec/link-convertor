package com.tlc.service;

import com.tlc.convertor.UrlConvertor;
import com.tlc.dto.UrlDTO;
import com.tlc.mapper.DeeplinkEntityMapper;
import com.tlc.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlConverterServiceImpl implements UrlConverterService{
    private final UrlRepository repository;
    private final UrlConvertor convertor;
    private final DeeplinkEntityMapper mapper;

    @Override
    public UrlDTO urlToDeeplink(UrlDTO webUrl) {
        log.debug("Start converting from webUrl to deeplink webUrl: {}", webUrl);
        var entity = mapper.toEntity(webUrl);
        entity.setDeepLink(convertor.convertToDeepLink(entity.getUrl()));
        log.debug("Result of converting webUrl to deeplink entity: {}", entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public UrlDTO deeplinkToUrl(UrlDTO deeplink) {
        log.debug("Start converting from deeplink to deeplink: {}", deeplink);
        var entity = mapper.toEntity(deeplink);
        entity.setUrl(convertor.convertToUrl(entity.getDeepLink()));
        log.debug("Result of converting from webUrl to entity: {}", entity);
        return mapper.toDTO(repository.save(entity));
    }
}
