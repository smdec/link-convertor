package com.tlc.service;

import com.tlc.dto.UrlDTO;

/**
 * Abstracts actual conversion realization
 */
public interface UrlConverterService {
    UrlDTO urlToDeeplink(UrlDTO webUrl);
    UrlDTO deeplinkToUrl(UrlDTO deeplink);
}
