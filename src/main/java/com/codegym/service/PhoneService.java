package com.codegym.service;

import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {

    Page<Phone> findAll(Pageable pageable);

    Phone findById(int id);

    void save(Phone phone);

    void delete(int id);

    Iterable<Phone> findAllByCategory(Phone phone);

    Page<Phone> findAllByName(String name, Pageable pageable);

    Page<Phone> findAllByOrderByDateOfPurchaseAsc(Pageable pageable);

    Page<Phone> findAllByOrderByDateOfPurchaseDesc(Pageable pageable);

    Page<Phone> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Phone> findAllByOrderByPriceDesc(Pageable pageable);
}
