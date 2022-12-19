package com.expansao.java.controller;

import com.expansao.java.dto.ProductorDto;
import com.expansao.java.service.ProductorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productor")
public class ProductorController {
    
    
    @Autowired
    private ProductorService productorService;
    
   @GetMapping("/store/{idStore}")
   public ResponseEntity<List<ProductorDto>> buscarProdutoPorLoja(@PathVariable long idStore) {
       return new ResponseEntity<List<ProductorDto>>(productorService.productorByStore(idStore), HttpStatus.OK);
   }
   
   @PostMapping
   public ResponseEntity criaNovoProductor(@RequestBody ProductorDto productor) {
       try {
           productorService.adicionarProductor(productor);
           return new ResponseEntity<>(HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
   
   @PutMapping("/{id}")
   public ResponseEntity editaProductor(@RequestBody ProductorDto productor, @PathVariable long id) {
       try {
           productorService.editarProductor(productor, id);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity removerProductor(@PathVariable long id) {
       try {
           productorService.deleteProductor(id);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
    
}
