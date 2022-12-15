package com.expansao.java.service;

import com.expansao.java.dto.StoreDto;
import com.expansao.java.model.Store;
import com.expansao.java.repository.StoreRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    
    //Fazendo injeção de dependecias de todas as funcionabilidades de StoreRepository dentro StoreService;
    @Autowired
    private StoreRepository storeRepository;
    
    public List<StoreDto> buscarLoja() throws Exception {
        List<Store> stores = storeRepository.findAll();
        if (stores.isEmpty()) {
            throw new Exception();
        }
        
        return mapStoreDto(stores);
    }

    private List<StoreDto> mapStoreDto(List<Store> stores) {
        
        List<StoreDto> storeDtos = new ArrayList<>(); //Criando uma lisa vazia;
        
        stores.forEach(item->{
            StoreDto dto = new StoreDto(item.getName(), item.getAddress(), item.getPhone());
            storeDtos.add(dto);
        });
        
        return storeDtos;
    }
    
}
