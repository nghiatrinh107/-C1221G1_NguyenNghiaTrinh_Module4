package com.codegym.repository.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(      value = "select * from facility where facility_name like :nameVal and service_type_id like :typeSearch and rent_type_id like :rentSearch",
            countQuery = "select * from facility where facility_name like :nameVal and service_type_id like :typeSearch and rent_type_id like :rentSearch ", nativeQuery = true)
    Page<Facility> findAndSearch(@Param("nameVal") String nameVal, @Param("typeSearch")String typeSearch, @Param("rentSearch")String rentSearch, Pageable pageable);
}

