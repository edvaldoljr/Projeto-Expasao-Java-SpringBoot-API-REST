package com.expansao.java.controller;

import com.expansao.java.dto.StoreDto;
import com.expansao.java.service.StoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {
    
    @Autowired
    private StoreService storeService;
    
    @GetMapping
    public ResponseEntity<List<StoreDto>> buscarLojas() throws Exception {
        return new ResponseEntity<List<StoreDto>>(storeService.buscarLoja(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity criaNovaLoja(@RequestBody StoreDto store) {
        try {
            storeService.adicionarLoja(store);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
