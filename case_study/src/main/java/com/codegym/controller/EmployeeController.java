package com.codegym.controller;

import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;
    @GetMapping(value ={"/","/list"})
    public 
}
