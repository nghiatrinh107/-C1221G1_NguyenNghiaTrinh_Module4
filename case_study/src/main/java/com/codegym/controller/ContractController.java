package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
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
@RequestMapping(value = "/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping(value = {"/list", ""})
    public String goList(Model model,
                         @RequestParam("customer") Optional<String> customerS,
                         @RequestParam("employee") Optional<String> employeeS,
                         @RequestParam("facility") Optional<String> facilityS,
                         @RequestParam("sort") Optional<String> sort,
                         @PageableDefault(value = 3, sort = {}) Pageable pageable) {
        String customer = customerS.orElse("%");
        String employee = employeeS.orElse("%");
        String facility = facilityS.orElse("%");
        String sortByDate = sort.orElse("");
        model.addAttribute("customerSearch", customer);
        model.addAttribute("employeeSearch", employee);
        model.addAttribute("facilitySearch", facility);
        model.addAttribute("sort", sortByDate);
        model.addAttribute("contracts", this.iContractService.findAndSearch(customer, employee, facility, pageable));
        model.addAttribute("customers", this.iCustomerService.findAll());
        model.addAttribute("employees", this.iEmployeeService.findAll());
        model.addAttribute("facilities", this.iFacilityService.findAll());
        return "contract/list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customers", this.iCustomerService.findAll());
        model.addAttribute("employees", this.iEmployeeService.findAll());
        model.addAttribute("facilities", this.iFacilityService.findAll());
        return "contract/create";
    }

    @PostMapping(value = "/create")
    public String createContract(Model model, @ModelAttribute @Validated ContractDto contractDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customers", this.iCustomerService.findAll());
            model.addAttribute("employees", this.iEmployeeService.findAll());
            model.addAttribute("facilities", this.iFacilityService.findAll());
            return "contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            this.iContractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            return "redirect:/contract/list";
        }


    }
}
