package com.tlc.convertor.strategy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Abstracts actual conversion realization
 */
public interface Convertor {
    String convert(String url) throws MalformedURLException, URISyntaxException;
    boolean isStrategyAcceptable(String path);
}
