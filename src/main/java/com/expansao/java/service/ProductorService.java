package com.expansao.java.service;

import com.expansao.java.dto.ProductorDto;
import com.expansao.java.model.Productor;
import com.expansao.java.model.Store;
import com.expansao.java.repository.ProductorRepository;
import com.expansao.java.repository.StoreRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductorService {
    
    @Autowired
    ProductorRepository productorRepository;
    
    @Autowired
    StoreRepository storeRepository;
    
    //Method GET
    public List<ProductorDto> productorByStore(long idStore) {
        
        List<Productor> productorByStore = productorRepository.findByStoreId(idStore);
        
        return mapProductorDto(productorByStore);
    }
    
    //Method POST
    public void adicionarProductor(ProductorDto productor) {
        Store store = storeRepository.findById(productor.getIdStore()).get();
        productorRepository.save(new Productor(store, productor.getBrand(), productor.getModel(), productor.getDescription(), productor.getPrice()));
    }
    
    //Method PUT
    public void editarProductor(ProductorDto productor, long id) {
        productorRepository.findById(id).ifPresentOrElse(item->{
            item.setDescription(productor.getDescription());
            item.setPrice(productor.getPrice());
            productorRepository.save(item);
        }, ()->{
            throw new NoSuchElementException();
        });
    }
    
    //Method DELETE
    public void deleteProductor(long id) {
        
        Productor productor = productorRepository.findById(id).get();
        productorRepository.delete(productor);
    }
    
    private List<ProductorDto> mapProductorDto(List<Productor> productor) {
        
        List<ProductorDto> productorDto = new ArrayList<>(); //Criando uma lisa vazia;
        
        productor.forEach(item->{
            ProductorDto prods = new ProductorDto(item.getId(), item.getStore().getId() ,item.getBrand(), item.getModel(), item.getDescription(), item.getPrice());
            productorDto.add(prods);
        });
        
        return productorDto;
    }
    
}
