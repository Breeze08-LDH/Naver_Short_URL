package com.breeze.springapi.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NaverUriDTO {
    private String message;
    private String code;
    private Result result;

    @Getter
    @Setter
    public static class Result {
        private String hash;
        private String url;
        private String orgUrl;
    }
}
