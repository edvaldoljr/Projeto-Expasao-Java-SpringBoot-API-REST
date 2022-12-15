package com.expansao.java.dto;


import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Lombok para criar nossos geters and seters;
@AllArgsConstructor
public class ProductorDto {
    
    private Long id;
    private Long idStore;
    private String brand;
    private String model;
    private String description;
    
    private BigDecimal price;
}
