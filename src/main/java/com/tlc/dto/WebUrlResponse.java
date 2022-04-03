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
public class WebUrlResponse {
    private String url;
}
