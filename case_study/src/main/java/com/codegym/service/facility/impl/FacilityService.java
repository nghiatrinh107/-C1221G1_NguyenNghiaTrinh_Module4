package com.codegym.service.facility.impl;

import com.codegym.model.facility.Facility;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findAndSearch(String nameVal, String typeSearch, String rentSearch, Pageable pageable) {
        return iFacilityRepository.findAndSearch("%"+nameVal+"%",typeSearch,rentSearch,pageable);
    }

    @Override
    public void save(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public List<Facility> findAll() {
        return this.iFacilityRepository.findAll();
    }

    @Override
    public Facility findById(Integer id) {
        return iFacilityRepository.findById(id).orElse(null);
    }
}
