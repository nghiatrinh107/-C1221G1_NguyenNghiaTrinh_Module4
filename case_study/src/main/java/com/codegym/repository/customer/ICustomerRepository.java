package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from customer where customer_name like :nameVal and customer_address like :address and customer_type_id like :type",
            countQuery = "select * from customer where customer_name like :nameVal and customer_address like :address and customer_type_id like :type", nativeQuery = true)
    Page<Customer> findAndSearch(@Param("nameVal") String nameVal,@Param("type") String typeFind,@Param("address") String addressFind, Pageable pageable);
}
