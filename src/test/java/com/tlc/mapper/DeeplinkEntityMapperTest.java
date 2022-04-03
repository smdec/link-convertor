package com.tlc.mapper;

import com.tlc.dto.UrlDtoRequest;
import com.tlc.dto.DeepLinkResponse;
import com.tlc.dto.WebUrlResponse;
import com.tlc.model.UrlEntity;
import com.tlc.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DeeplinkEntityMapper.class, DeeplinkEntityMapperImpl.class})
class DeeplinkEntityMapperTest {
    @Autowired
    private DeeplinkEntityMapper mapper;

    @Test
    void testToEntity() {
        var dto = TestUtil.nextObject(UrlDtoRequest.class);
        var entity = mapper.toEntity(dto);

        assertEquals(entity.getUrl(), dto.getUrl());
        assertEquals(UrlDtoRequest.class, dto.getClass());
    }

    @Test
    void testToDTO() {
        var entity = TestUtil.nextObject(UrlEntity.class);
        var deepLink = mapper.toDeepLinkResponse(entity);
        var webUrl = mapper.toWebUrlResponse(entity);

        assertEquals(entity.getDeepLink(), deepLink.getUrl());
        assertEquals(DeepLinkResponse.class, deepLink.getClass());

        assertEquals(entity.getUrl(), webUrl.getUrl());
        assertEquals(WebUrlResponse.class, webUrl.getClass());
    }
}