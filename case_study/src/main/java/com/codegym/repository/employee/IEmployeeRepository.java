package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where employee_name like :nameVal and position_id like :positionSearch and division_id like :divisionSearch and education_degree_id like :eDSearch",
            countQuery = "select * from employee where employee_name like :nameVal and position_id like :positionSearch and division_id like :divisionSearch and education_degree_id like :eDSearch", nativeQuery = true)
    Page<Employee> findAndSearch(String nameVal, String positionSearch, String divisionSearch, String eDSearch, Pageable pageable);
}
