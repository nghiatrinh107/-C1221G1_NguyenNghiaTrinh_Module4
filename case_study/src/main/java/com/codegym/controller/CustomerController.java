package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
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
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = {"/list", ""})
    public String goList(Model model,
                         @RequestParam("name") Optional<String> name,
                         @RequestParam("address") Optional<String> address,
                         @RequestParam("type") Optional<String> customerType,
                         @RequestParam("sort") Optional<String> sort,
                         @PageableDefault(value = 2, sort = {}) Pageable pageable) {
        String nameVal = name.orElse("");
        String sortByName = sort.orElse("");
        String typeFind = customerType.orElse("%");
        String addressFind = address.orElse("");
        model.addAttribute("type", typeFind);
        model.addAttribute("address", addressFind);
        model.addAttribute("name", nameVal);
        model.addAttribute("sort", sortByName);
        model.addAttribute("customers", this.iCustomerService.findAndSearch(nameVal, typeFind, addressFind, pageable));
        model.addAttribute("types", this.iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String goCreateCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("types", this.iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(Model model, @ModelAttribute @Validated CustomerDto customerDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("types", this.iCustomerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            this.iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            return "redirect:/customer/list";
        }
    }
    @GetMapping(value = "/edit")
    public String goEditCustomer(@RequestParam Integer id, Model model){
        Customer customer = iCustomerService.findById(id);
        CustomerDto  customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        model.addAttribute("types", this.iCustomerTypeService.findAll());
        return "customer/edit";
    }
    @PostMapping(value = "/edit")
    public String editCustomer(Model model,@ModelAttribute @Validated CustomerDto customerDto,
                               BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            this.iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Edit OK!");
            return "redirect:/customer/list";
        }

    }
    @GetMapping(value = "/delete")
    public String deleteCustomer(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        this.iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete OK!");
        return "redirect:/customer/list";
    }

}

