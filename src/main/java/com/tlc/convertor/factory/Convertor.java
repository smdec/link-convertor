package com.tlc.convertor.factory;

/**
 * Abstracts actual conversion realization
 */
public interface Convertor {
    String convert(String url);
}
