package com.example.StorehouseDBJ.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String userEmail;
    private String password;
}
