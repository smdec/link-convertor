package com.tlc.service;

import com.tlc.dto.UrlDtoRequest;
import com.tlc.dto.DeepLinkResponse;
import com.tlc.dto.WebUrlResponse;

/**
 * Abstracts actual conversion realization
 */
public interface UrlConverterService {
    DeepLinkResponse urlToDeeplink(UrlDtoRequest webUrl);
    WebUrlResponse deeplinkToUrl(UrlDtoRequest deeplink);
}
