package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface ICustomerService {

    Page<Customer> findAndSearch(String nameVal, String typeFind, String addressFind, Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    void remove(Integer id);
}
