package com.expansao.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Lombok para criar nossos geters and seters;
@AllArgsConstructor // Construtor com todos os argumentos;
public class StoreDto {
    
    private String name;
    private String address;
    private String phone;
    
}
