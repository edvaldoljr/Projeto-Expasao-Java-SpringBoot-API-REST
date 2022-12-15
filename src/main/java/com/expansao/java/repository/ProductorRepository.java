package com.expansao.java.repository;

import com.expansao.java.model.Productor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Informando ao SpringBoot que essa classe tem papéis especificos dentro da lógica da nossa aplicação;
public interface ProductorRepository extends JpaRepository<Productor, Long>{
    
    List<Productor> findByStoreId(long idSttore);
}
