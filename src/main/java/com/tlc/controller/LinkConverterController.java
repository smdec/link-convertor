package com.tlc.controller;

import com.tlc.dto.UrlDTO;
import com.tlc.service.UrlConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/linkConvert/")
@RequiredArgsConstructor
public class LinkConverterController {

    private final UrlConverterService service;

    /**
     * @param webUrl
     * @return UrlDTO
     */
    @PostMapping("deep-link")
    public ResponseEntity<UrlDTO> urlToDeeplink(@RequestBody UrlDTO webUrl) {
        return ResponseEntity.ok(service.urlToDeeplink(webUrl));
    }

    /**
     * @param deeplink
     * @return UrlDTO
     */
    @PostMapping("web-url")
    public ResponseEntity<UrlDTO> DeeplinkToUrl(@RequestBody UrlDTO deeplink) {
        return ResponseEntity.ok(service.deeplinkToUrl(deeplink));
    }
}
