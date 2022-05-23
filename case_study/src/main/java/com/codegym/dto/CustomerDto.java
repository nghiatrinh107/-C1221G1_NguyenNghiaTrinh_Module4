package com.codegym.dto;

import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


public class CustomerDto implements Validator {
    private Integer customerId;
    @NotNull(message = "Chọn loại khách hàng")
    private CustomerType customerType;
    @NotEmpty(message = "Not Null")
    @Pattern(regexp = "^((\\p{Lu}(\\p{Ll})+)(\\s)?)+$",message = "Tên không chứa kí tự đặt biệt và số (Nguyễn Văn A) ")
    private String customerName;
    @NotEmpty(message = "Not Null")
    private String customerBirth;
    @NotNull(message = "Chọn giới tính")
    private Integer customerGender;

    @Pattern(regexp = "\\d{9}|\\d{12}",message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String customerIdCard;
    @Pattern(regexp = "((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}",message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;
    @NotEmpty(message = "Not Null")
    @Email
    private String customerEmail;
    @NotEmpty(message = "Not Null")
    private String customerAddress;

    public CustomerDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
