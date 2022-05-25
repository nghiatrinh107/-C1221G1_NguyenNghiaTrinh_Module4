package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
@Autowired
private ICustomerRepository iCustomerRepository;
private Customer customer;

    @Override
    public Page<Customer> findAndSearch(String nameVal, String typeFind, String addressFind, Pageable pageable) {
       return this.iCustomerRepository.findAndSearch("%"+nameVal+"%",typeFind,"%"+addressFind+"%",pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        customer = iCustomerRepository.findById(id).orElse(null);
        customer.setStatus(0);
        iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }


}
