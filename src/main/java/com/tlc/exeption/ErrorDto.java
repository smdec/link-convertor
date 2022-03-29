package com.tlc.exeption;

import lombok.Data;

@Data
public class ErrorDto extends RuntimeException {
    private String errorMassage;
}
