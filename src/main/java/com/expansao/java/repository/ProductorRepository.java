package com.expansao.java.repository;

import com.expansao.java.model.Productor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Informando ao SpringBoot que essa classe tem papéis especificos dentro da lógica da nossa aplicação;
public interface ProductorRepository extends JpaRepository<Productor, Long>{
    
}
