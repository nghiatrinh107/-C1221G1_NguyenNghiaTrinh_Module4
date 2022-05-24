package com.codegym.controller;

import com.codegym.dto.FacilityDto;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IRentTypeService;
import com.codegym.service.facility.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {
    @Autowired
    private IServiceTypeService iServiceTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping(value = {"","/list"})
    public String goList(Model model,
                         @RequestParam("name") Optional<String> name,
                         @RequestParam("rentType") Optional<String> rent,
                         @RequestParam("type") Optional<String> serviceType,
                         @RequestParam("sort") Optional<String> sort,
                         @PageableDefault(value = 2, sort = {}) Pageable pageable){
        String nameVal = name.orElse("");
        String sortByName = sort.orElse("");
        String rentSearch = rent.orElse("%");
        String typeSearch = serviceType.orElse("%");
        model.addAttribute("type",typeSearch);
        model.addAttribute("rent",rentSearch);
        model.addAttribute("name",nameVal);
        model.addAttribute("sort", sortByName);
        model.addAttribute("facilities",this.iFacilityService.findAndSearch(nameVal,typeSearch,rentSearch,pageable));
        model.addAttribute("rentTypes",this.iRentTypeService.findAll());
        model.addAttribute("serviceTypes",this.iServiceTypeService.findAll());
        return "facility/list";
    }
    @GetMapping(value = "/create")
    public String goCreateFacility(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("rentTypes",this.iRentTypeService.findAll());
        model.addAttribute("serviceTypes",this.iServiceTypeService.findAll());
        return "facility/create";
    }
}
