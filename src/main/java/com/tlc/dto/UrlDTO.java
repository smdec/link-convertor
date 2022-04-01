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
public class UrlDTO {
    private String url;
    private String deepLink;
}
