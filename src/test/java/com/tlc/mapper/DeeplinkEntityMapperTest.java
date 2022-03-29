package com.tlc.mapper;

import com.tlc.dto.UrlDTO;
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
        var dto = TestUtil.nextObject(UrlDTO.class);
        var entity = mapper.toEntity(dto);

        assertEquals(entity.getUrl(), dto.getUrl());
        assertEquals(entity.getDeepLink(), dto.getDeepLink());
    }

    @Test
    void testToDTO() {
        var entity = TestUtil.nextObject(UrlEntity.class);
        var dto = mapper.toDTO(entity);

        assertEquals(entity.getUrl(), dto.getUrl());
        assertEquals(entity.getDeepLink(), dto.getDeepLink());
    }
}