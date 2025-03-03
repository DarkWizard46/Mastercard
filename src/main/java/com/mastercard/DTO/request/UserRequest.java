package com.mastercard.DTO.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserRequest {
    private String nik;
    private String username;
    private String name;
    private String password;
    private String privilege;
}
