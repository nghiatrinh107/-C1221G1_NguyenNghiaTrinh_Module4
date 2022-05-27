package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class ContractDto implements Validator {
    private Integer contractId;
    private String contractStartDay;
    private String contractEndDay;
    @NotBlank(message = "not null")
    @Pattern(regexp = "[+]?\\d+", message = "Tiền bằng số,không có kí tự đặc biệt")
    private String contractDeposit;
    @NotBlank(message = "not null")
    @Pattern(regexp = "[+]?\\d+", message = "Tiền bằng số,không có kí tự đặc biệt")
    private String contractTotalMoney;
    @NotNull(message = "not null")
    private Employee employee;
    @NotNull(message = "not null")
    private Facility facility;
    @NotNull(message = "not null")
    private Customer customer;

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public String getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(String contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if("".equals(contractDto.getContractStartDay())) {
            errors.rejectValue("contractStartDay", "date.null", "nilnon");
        }else
            if (LocalDate.parse(contractDto.getContractStartDay()).isBefore(LocalDate.now())) {
            errors.rejectValue("contractStartDay", "date.start", "Nonnn");
        }

        if("".equals(contractDto.getContractEndDay())) {
            errors.rejectValue("contractEndDay", "date.null", "nilnon1");
        }else
        if("".equals(contractDto.getContractStartDay())) {

        }else
        if (LocalDate.parse(contractDto.getContractEndDay()).isBefore(LocalDate.parse(contractDto.getContractStartDay()))) {
            errors.rejectValue("contractEndDay", "date.end", "nonnn");
        }
    }

}
