package com.tlc.controller;

import com.tlc.dto.UrlDtoRequest;
import com.tlc.dto.DeepLinkResponse;
import com.tlc.dto.WebUrlResponse;
import com.tlc.service.UrlConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint to be used on converting web url to deep link and deep link to web url
 */
@RestController
@RequestMapping("/api/linkConvert/")
@RequiredArgsConstructor
public class LinkConverterController {

    private final UrlConverterService service;

    /**
     * Endpoint for converting web url to deep link
     *
     * @param webUrl request param for link to be converted
     * @return ResponseEntity with UrlDTO that wraps converted link and http status code
     */
    @PostMapping("deep-link")
    public ResponseEntity<DeepLinkResponse> urlToDeeplink(@RequestBody UrlDtoRequest webUrl) {
        return ResponseEntity.ok(service.urlToDeeplink(webUrl));
    }

    /**
     * Endpoint for converting deep link to  web url
     *
     * @param deeplink request param for link to be converted
     * @return ResponseEntity with UrlDTO that wraps converted link and http status code
     */
    @PostMapping("web-url")
    public ResponseEntity<WebUrlResponse> deeplinkToUrl(@RequestBody UrlDtoRequest deeplink) {
        return ResponseEntity.ok(service.deeplinkToUrl(deeplink));
    }
}
