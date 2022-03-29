package com.tlc.service;

import com.tlc.dto.UrlDTO;

public interface UrlConverterService {
    UrlDTO urlToDeeplink(UrlDTO webUrl);
    UrlDTO deeplinkToUrl(UrlDTO deeplink);
}
