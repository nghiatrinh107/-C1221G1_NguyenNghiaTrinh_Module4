package com.codegym.model.facility;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.CustomerType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facilityId;
    private String facilityName;
    @Column(columnDefinition = "INT")
    private Integer facilityArea;
    @Column(columnDefinition = "DOUBLE")
    private String facilityCost;
    @Column(columnDefinition = "INT")
    private String facilityMaxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rentTypeId")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Column(columnDefinition = "DOUBLE")
    private String poolArea;
    @Column(columnDefinition = "INT")
    private String numberOfFloors;

    @OneToMany(mappedBy = "facility",cascade = CascadeType.ALL)
    private List<Contract> contractList;
    public Facility() {
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Integer getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(Integer facilityArea) {
        this.facilityArea = facilityArea;
    }

    public String getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(String facilityCost) {
        this.facilityCost = facilityCost;
    }

    public String getFacilityMaxPeople() {
        return facilityMaxPeople;
    }

    public void setFacilityMaxPeople(String facilityMaxPeople) {
        this.facilityMaxPeople = facilityMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "facilityId=" + facilityId +
                ", facilityName='" + facilityName + '\'' +
                ", facilityArea=" + facilityArea +
                ", facilityCost='" + facilityCost + '\'' +
                ", facilityMaxPeople='" + facilityMaxPeople + '\'' +
                ", rentType=" + rentType +
                ", serviceType=" + serviceType +
                ", standardRoom='" + standardRoom + '\'' +
                ", descriptionOtherConvenience='" + descriptionOtherConvenience + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\'' +
                ", contractList=" + contractList +
                '}';
    }
}
