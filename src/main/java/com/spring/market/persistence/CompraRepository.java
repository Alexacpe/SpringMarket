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

    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        //convertir de una lista de compras a una lista de Purchases
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {//recibe un purchase, hay que convertirlo a compra
        Compra compra = mapper.toCompra(purchase);
        //Guardar en cascada validando que compra conoce los productos conocen a que compra pertenecen
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
