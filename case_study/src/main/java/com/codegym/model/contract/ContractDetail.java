package com.codegym.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContractDetail;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;
    @Column(columnDefinition = "INTEGER")
    private String quantity;

    public ContractDetail() {
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
}
