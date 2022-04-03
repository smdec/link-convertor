package com.tlc.mapper;

import com.tlc.dto.UrlDtoRequest;
import com.tlc.dto.DeepLinkResponse;
import com.tlc.dto.WebUrlResponse;
import com.tlc.model.UrlEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Represents mapper
 *
 */
@Mapper(componentModel = "spring")
public interface DeeplinkEntityMapper {

    /**
     * Method convert UrlDTO to UrlEntity
     *
     * @param dto
     * @returnu entity
     */
    @Mapping(source = "url", target = "url")
    UrlEntity toEntity(UrlDtoRequest dto);

    /**
     * Method convert UrlEntity to UrlDTO
     *
     * @param entity
     * @return dto
     */
    @Mapping(source = "deepLink", target = "url")
    DeepLinkResponse toDeepLinkResponse(UrlEntity entity);

    /**
     * Method convert UrlEntity to UrlDTO
     *
     * @param entity
     * @return dto
     */
    @Mapping(source = "url", target = "url")
    WebUrlResponse toWebUrlResponse(UrlEntity entity);
}
