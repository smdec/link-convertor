package com.tlc.convertor.strategy;

/**
 * Abstracts actual conversion realization
 */
public interface Convertor {
    String convert(String url);
    boolean isStrategyAcceptable(String path);
}
