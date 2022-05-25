package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract where customer_id like :customer and employee_id like :employee and facility_id like :facility",
            countQuery = "select * from contract where customer_id like :customer and employee_id like :employee and facility_id like :facility", nativeQuery = true)
    Page<Contract> findAndSearch(String customer, String employee, String facility, Pageable pageable);

}
