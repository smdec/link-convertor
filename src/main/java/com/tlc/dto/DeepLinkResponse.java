package com.tlc.dto;

import lombok.*;

/**
 * Represents UrlDtoResponse
 */
@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeepLinkResponse {
    private String url;
}
