package com.tlc.mapper;

import com.tlc.dto.UrlDTO;
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
    @Mapping(source = "deepLink", target = "deepLink")
    UrlEntity toEntity(UrlDTO dto);

    /**
     * Method convert UrlEntity to UrlDTO
     *
     * @param entity
     * @return dto
     */
    @Mapping(source = "url", target = "url")
    @Mapping(source = "deepLink", target = "deepLink")
    UrlDTO toDTO(UrlEntity entity);
}
