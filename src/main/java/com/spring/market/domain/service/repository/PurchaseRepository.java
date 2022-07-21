package com.spring.market.domain.service.repository;

import com.spring.market.domain.Purchase;

import java.util.List;
import java.util.Optional;
/**Interface que trae la lista de compras, trae compras por cliente y guarda compras**/
public interface PurchaseRepository {
    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientId);

    Purchase save(Purchase purchase);
}
