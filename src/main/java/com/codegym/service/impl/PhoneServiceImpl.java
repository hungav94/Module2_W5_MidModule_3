package com.codegym.service.impl;

import com.codegym.model.Phone;
import com.codegym.repository.PhoneRepository;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;


    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }

    @Override
    public Phone findById(int id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void delete(int id) {
        phoneRepository.delete(id);
    }

    @Override
    public Iterable<Phone> findAllByCategory(Phone phone) {
        return phoneRepository.findAllByCategory(phone);
    }

    @Override
    public Page<Phone> findAllByName(String name, Pageable pageable) {
        return phoneRepository.findAllByName(name, pageable);
    }

    @Override
    public Page<Phone> findAllByOrderByDateOfPurchaseAsc(Pageable pageable) {
        return phoneRepository.findAllByOrderByDateOfPurchaseAsc(pageable);
    }

    @Override
    public Page<Phone> findAllByOrderByDateOfPurchaseDesc(Pageable pageable) {
        return phoneRepository.findAllByOrderByDateOfPurchaseDesc(pageable);
    }

    @Override
    public Page<Phone> findAllByOrderByPriceAsc(Pageable pageable) {
        return phoneRepository.findAllByOrderByPriceAsc(pageable);
    }

    @Override
    public Page<Phone> findAllByOrderByPriceDesc(Pageable pageable) {
        return phoneRepository.findAllByOrderByPriceDesc(pageable);
    }
}
