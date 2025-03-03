package com.mastercard.DTO.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class LoginResponse {
    private String username;
    private String token;
    private List<String> privilege;
}
