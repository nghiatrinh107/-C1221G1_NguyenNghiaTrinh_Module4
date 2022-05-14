package com.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {
    private Integer id;
    @NotBlank(message = "Not Null")
    @Size(min = 5, max = 45, message = "số kí tự từ 5-45")
    private String firstName;
    @NotBlank(message = "Not Null")
    @Size(min = 5, max = 45, message = "số kí tự từ 5-45")
    private String lastName;
    @NotBlank(message = "Not Null")
    @Pattern(regexp = "(^$|[0-9]*$)")
    private String phone;
    private String dateOfBirth;
    @NotBlank(message = "Not Null")
    @Email
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("".equals(userDto.getDateOfBirth())) {
            errors.rejectValue("dateOfBirth", "date.null", "nonnn");
        } else {
            if ((Period.between(LocalDate.parse(userDto.getDateOfBirth()), LocalDate.now()).getYears()) < 18) {
                errors.rejectValue("dateOfBirth", "date.age", "NONNN");
            }
        }
    }
}
