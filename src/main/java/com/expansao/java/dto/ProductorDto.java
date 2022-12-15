package com.expansao.java.dto;


import lombok.Data;

@Data // Lombok para criar nossos geters and seters;
public class ProductorDto {
    
    private Long idStore;
    private String brand;
    private String model;
    private String description;
}
