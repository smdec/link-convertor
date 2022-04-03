package com.tlc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlc.dto.DeepLinkResponse;
import com.tlc.dto.UrlDtoRequest;
import com.tlc.dto.WebUrlResponse;
import com.tlc.service.UrlConverterServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LinkConverterController.class)
class LinkConverterControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    UrlConverterServiceImpl service;


    @Test
    void urlToDeeplink() throws Exception {
        var request = UrlDtoRequest.builder()
                .url("https://www.trendyol.com/Hesabim/Favoriler")
                .build();

        var response = DeepLinkResponse.builder()
                .url("ty://?Page=Home")
                .build();

        Mockito.when(service.urlToDeeplink(request)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/linkConvert/deep-link")
                        .content(mapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.url", is("ty://?Page=Home")));
    }

    @Test
    void deeplinkToUrl() throws Exception {
        var request = UrlDtoRequest.builder()
                .url("ty://?Page=Favorites")
                .build();

        var response = WebUrlResponse.builder()
                .url("https://www.trendyol.com")
                .build();

        Mockito.when(service.deeplinkToUrl(request)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/linkConvert/web-url")
                        .content(mapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.url", is("https://www.trendyol.com")));
    }
}