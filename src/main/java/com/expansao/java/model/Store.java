package com.expansao.java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Dizer que essa classe é uma entidade do banco de dados;
@Data // Lombok para criar nossos geters and seters;
@NoArgsConstructor //Criando o método construtor;
public class Store {

    @Id // Dizendo que este atributo é unico no banco de dados;
    @GeneratedValue(strategy = GenerationType.AUTO) //Pedindo que cada vez que inserirmos um novo dado no  banco de dados ele irá criar um novo ID na seguência;
    private Long id;
    private String name;
    private String address;
    private String phone;


}
