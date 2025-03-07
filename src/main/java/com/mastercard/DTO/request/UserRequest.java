package com.mastercard.DTO.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class UserRequest {
    @NotBlank(message = "nik is required")
    private String nik;
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "password is required")
    private String password;
    private List<String> privilege;
}
