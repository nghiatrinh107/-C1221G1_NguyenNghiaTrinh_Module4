package com.codegym.service;

import com.codegym.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();

    Page<SmartPhone> findAllPage(Pageable pageable);

    SmartPhone findById(Long id);

    void save(SmartPhone smartPhone);

    void remove(Long id);
    Page<SmartPhone> showAll(String keyword, Pageable pageable);
}
