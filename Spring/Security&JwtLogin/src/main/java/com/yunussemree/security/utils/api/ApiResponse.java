package com.yunussemree.security.utils.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;
}
