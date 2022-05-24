package com.codegym.controller;


import com.codegym.dto.EmployeeDto;
import com.codegym.model.employee.Employee;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
    @GetMapping(value ={"","/list"})
    public String goList(Model model,
                         @RequestParam("name") Optional<String> name,
                         @RequestParam("division") Optional<String> division,
                         @RequestParam("position") Optional<String> position,
                         @RequestParam("educationDegree") Optional<String> educationDegree,
                         @RequestParam("sort") Optional<String> sort,
                         @PageableDefault(value = 3, sort = {}) Pageable pageable){
        String nameSearch = name.orElse("");
        String positionSearch = position.orElse("%");
        String divisionSearch = division.orElse("%");
        String eDSearch = educationDegree.orElse("%");
        String sortByName = sort.orElse("");
        model.addAttribute("position",positionSearch);
        model.addAttribute("division",divisionSearch);
        model.addAttribute("educationDegree",eDSearch);
        model.addAttribute("name",nameSearch);
        model.addAttribute("sort",sortByName);
        model.addAttribute("employees",this.iEmployeeService.findAndSearch(nameSearch,positionSearch,divisionSearch,eDSearch,pageable));
        model.addAttribute("positions",this.iPositionService.findAll());
        model.addAttribute("divisions",this.iDivisionService.findAll());
        model.addAttribute("educationDegrees",this.iEducationDegreeService.findAll());
        return "employee/list";
    }
    @GetMapping(value = "/create")
    public String goCreateEmployee(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        model.addAttribute("positions",this.iPositionService.findAll());
        model.addAttribute("divisions",this.iDivisionService.findAll());
        model.addAttribute("educationDegrees",this.iEducationDegreeService.findAll());
        return "employee/create";
    }
    @PostMapping("/create")
    public String createEmployee(Model model, @ModelAttribute @Validated EmployeeDto employeeDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions",this.iPositionService.findAll());
            model.addAttribute("divisions",this.iDivisionService.findAll());
            model.addAttribute("educationDegrees",this.iEducationDegreeService.findAll());
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            return "redirect:/employee/list";
        }
    }
    @GetMapping(value = "/edit")
    public String goEditEmployee(@RequestParam Integer id,Model model){
        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        model.addAttribute("positions",this.iPositionService.findAll());
        model.addAttribute("divisions",this.iDivisionService.findAll());
        model.addAttribute("educationDegrees",this.iEducationDegreeService.findAll());
        return "employee/edit";
    }
    @PostMapping(value = "/edit")
    public String editEmployee(Model model,@ModelAttribute @Validated EmployeeDto employeeDto,
                               BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions",this.iPositionService.findAll());
            model.addAttribute("divisions",this.iDivisionService.findAll());
            model.addAttribute("educationDegrees",this.iEducationDegreeService.findAll());
            return "employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            return "redirect:/employee/list";
        }
    }
    @GetMapping(value = "/delete")
    public String deleteEmployee(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        this.iEmployeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete OK!");
        return "redirect:/employee/list";
    }
}
