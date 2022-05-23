package com.codegym.repository.facility;

import com.codegym.model.facility.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
