package com.codegym.service.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAndSearch(String nameVal, String typeSearch, String rentSearch, Pageable pageable);

    void save(Facility facility);

    List<Facility> findAll();

    Facility findById(Integer id);
}
