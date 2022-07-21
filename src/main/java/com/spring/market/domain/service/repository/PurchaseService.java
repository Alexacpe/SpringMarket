package com.spring.market.domain.service.repository;


import com.spring.market.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Se crea el servicio para trabajar en funcion al dominio y no al repositorio
@Service
public class PurchaseService {
    //inyectar el repositorio para usar sus metodos
    @Autowired
    private PurchaseRepository purchaseRepository;

    //metodos del repositorio
    //traer una lista con las compras
    public List<Purchase>getAll(){

        return purchaseRepository.getAll();
    }
    //compras por cliente
    public Optional<List<Purchase>>  getByClient(String clientId){
       return purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
