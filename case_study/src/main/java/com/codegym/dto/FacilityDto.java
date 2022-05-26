package com.codegym.dto;

import com.codegym.model.facility.Facility;
import com.codegym.model.facility.RentType;
import com.codegym.model.facility.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FacilityDto implements Validator {
    private Integer facilityId;
    @NotNull(message = "not null")
    private String facilityName;
    @NotNull(message = "not null")
    private Integer facilityArea;
    @NotNull(message = "not null")
    private String facilityCost;
    @NotNull(message = "not null")
    private String facilityMaxPeople;
    @NotNull(message = "not null")
    private RentType rentType;
    @NotNull(message = "not null")
    private ServiceType serviceType;
    @NotNull(message = "not null")
    private String standardRoom;
    @NotNull(message = "not null")
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloors;

    public FacilityDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        if (facilityDto.getServiceType().getServiceTypeId() == 1 && !facilityDto.getNumberOfFloors().matches("[+]?\\d+")) {
            errors.rejectValue("numberOfFloors", "facility.number", "Nonnn");
        }
        if (facilityDto.getServiceType().getServiceTypeId() == 1 && !facilityDto.getPoolArea().matches("[+]?\\d+")) {
            errors.rejectValue("poolArea", "facility.number", "Nonnn");
        }
        if (facilityDto.getServiceType().getServiceTypeId() == 2 && !facilityDto.getNumberOfFloors().matches("[+]?\\d+")) {
            errors.rejectValue("numberOfFloors", "facility.number", "Nonnn");
        }
    }
}
