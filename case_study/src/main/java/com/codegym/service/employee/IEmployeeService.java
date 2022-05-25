package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAndSearch(String nameSearch, String positionSearch, String divisionSearch, String eDSearch, Pageable pageable);

    void save(Employee employee);

    void delete(Integer id);

    Employee findById(Integer id);

    List<Employee> findAll();
}
