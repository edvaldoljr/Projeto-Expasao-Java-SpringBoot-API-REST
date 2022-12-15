package com.expansao.java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Dizer que essa classe é uma entidade do banco de dados;
@Data // Lombok para criar nossos geters and seters;
@NoArgsConstructor //Criando o método construtor;
public class Productor {
    
    @Id // Dizendo que este atributo é unico no banco de dados;
    @GeneratedValue(strategy = GenerationType.AUTO) //Pedindo que cada vez que inserirmos um novo dado no  banco de dados ele irá criar um novo ID na seguência;
    private Long id;
    
    @OneToOne // Diz que a nossa classe produto vai ter ligação com a classe loja e por conseguência no banco de dados a nossa tabela produto ter ligação com a tabela loja;
    @JoinColumn(name = "store_id", referencedColumnName = "id") //Dizendo que elas tem uma ligação de 1 para 1
    private Store store;
    private String brand;
    private String model;
    private String description;
    private BigDecimal price;
    
    //Consrutor sem necessidade de passar o Id;
    public Productor(Store store, String brand, String model, String description, BigDecimal price) {
        this.store = store;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.price = price;
    }
   
}
