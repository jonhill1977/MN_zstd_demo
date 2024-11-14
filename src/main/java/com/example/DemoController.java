package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class DemoController {

    private static final int SMALL_RESPONSE_SIZE = 32 * 1024;  // 32KiB
    private static final int LARGE_RESPONSE_SIZE = 32 * 1024 * 1024;  // 32MiB

    @Get("/large")
    public String largeResponse() {
        return response(LARGE_RESPONSE_SIZE);
    }

    @Get("/small")
    public String smallResponse() {
        return response(SMALL_RESPONSE_SIZE);
    }

    private String response(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("" + i % 10);
        }
        return sb.toString();
    }

}
