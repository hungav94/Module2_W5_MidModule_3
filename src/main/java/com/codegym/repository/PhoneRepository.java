package com.codegym.repository;

import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone, Integer> {
    Iterable<Phone> findAllByCategory(Phone phone);

    Page<Phone> findAllByName(String name, Pageable pageable);

    Page<Phone> findAllByOrderByDateOfPurchaseAsc(Pageable pageable);

    Page<Phone> findAllByOrderByDateOfPurchaseDesc(Pageable pageable);

    Page<Phone> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Phone> findAllByOrderByPriceDesc(Pageable pageable);
}
