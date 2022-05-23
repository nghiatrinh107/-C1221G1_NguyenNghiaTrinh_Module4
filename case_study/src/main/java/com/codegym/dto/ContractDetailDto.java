package com.codegym.dto;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class ContractDetailDto implements Validator {
    private Integer idContractDetail;
    @NotBlank
    private Contract contract;
    private AttachService attachService;
    private String quantity;

    public ContractDetailDto() {
    }

    public Integer getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(Integer idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
