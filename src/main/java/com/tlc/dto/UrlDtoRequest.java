package com.tlc.dto;

import lombok.*;

/**
 * Represents DTO
 */
@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UrlDtoRequest {
    private String url;
}
