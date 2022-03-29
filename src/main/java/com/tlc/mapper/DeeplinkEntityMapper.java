package com.tlc.mapper;

import com.tlc.dto.UrlDTO;
import com.tlc.model.UrlEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeeplinkEntityMapper {
    @Mapping(source = "url", target = "url")
    @Mapping(source = "deepLink", target = "deepLink")
    UrlEntity toEntity(UrlDTO deeplink);

    @Mapping(source = "url", target = "url")
    @Mapping(source = "deepLink", target = "deepLink")
    UrlDTO toDTO(UrlEntity deeplink);
}
