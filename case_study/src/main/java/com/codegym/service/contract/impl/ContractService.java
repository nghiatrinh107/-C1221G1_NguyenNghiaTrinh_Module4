package com.codegym.service.contract.impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.IContractDetailRepository;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Page<Contract> findAndSearch(String customer, String employee, String facility, Pageable pageable) {
        return iContractRepository.findAndSearch(customer,employee,facility,pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }
}
