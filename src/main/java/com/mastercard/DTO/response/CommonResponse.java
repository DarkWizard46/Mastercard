package com.mastercard.DTO.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Integer statusCode;
    private String message;
    private T data;
}
