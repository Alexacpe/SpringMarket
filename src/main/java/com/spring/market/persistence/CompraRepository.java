package com.spring.market.persistence;

import com.spring.market.domain.Purchase;
import com.spring.market.domain.service.repository.PurchaseRepository;
import com.spring.market.persistence.crud.CompraCrudRepository;
import com.spring.market.persistence.entity.Compra;
import com.spring.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    //inyectar la interface
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    //inyectar el mapper para que este repositorio hable en terminos de dominio
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());//retorna una lista de compras como purchase gracias a que el mapper lo transforma
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        //para guardar el purchase primero se convierte a compra
        Compra compra = mapper.toCompra(purchase);
        //garantizar que la informacion se va a guardar en cascada validando que compra conoce los productos, y los productos saben a que compra pertenecen
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));

    }
}

