package com.codegym.service.impl;

import com.codegym.model.SmartPhone;
import com.codegym.repository.ISmartPhoneRepository;
import com.codegym.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;
    @Override
    public Page<SmartPhone> showAll(String keyword, Pageable pageable) {
        return smartPhoneRepository.findAllByModelContaining(keyword, pageable);
    }

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Page<SmartPhone> findAllPage(Pageable pageable) {
        return smartPhoneRepository.findAll(pageable);
    }

    @Override
    public SmartPhone findById(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SmartPhone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
