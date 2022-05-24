package com.codegym.model.contract;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Service
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachServiceId;
    private String nameAttachService;
    @Column(columnDefinition = "DOUBLE")
    private String costAttachService;
    private String unitAttachService;
    private String statusAttachService;

    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int idAttachService) {
        this.attachServiceId = idAttachService;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }

    public String getCostAttachService() {
        return costAttachService;
    }

    public void setCostAttachService(String costAttachService) {
        this.costAttachService = costAttachService;
    }

    public String getUnitAttachService() {
        return unitAttachService;
    }

    public void setUnitAttachService(String unitAttachService) {
        this.unitAttachService = unitAttachService;
    }

    public String getStatusAttachService() {
        return statusAttachService;
    }

    public void setStatusAttachService(String statusAttachService) {
        this.statusAttachService = statusAttachService;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
