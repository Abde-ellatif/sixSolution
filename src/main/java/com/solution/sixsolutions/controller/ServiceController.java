package com.solution.sixsolutions.controller;


import com.solution.sixsolutions.dto.ServiceeDto;
import com.solution.sixsolutions.dto.req.ServiceReq;
import com.solution.sixsolutions.exception.EntrepriseException;
import com.solution.sixsolutions.exception.ServiceeException;

import com.solution.sixsolutions.service.SolutionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/sixsolution/service")
public class ServiceController {

    SolutionServiceImpl iSolutionService;
    @PostMapping("/add")
    public ServiceeDto saveService(@RequestBody ServiceReq serviceReq) throws ServiceeException, EntrepriseException {
        ServiceeDto service = iSolutionService.saveService(serviceReq);
        return service;
    }

    @GetMapping("{id}")
    public ServiceeDto getServiceById(@PathVariable(value = "id") Long id) throws ServiceeException {
        ServiceeDto memo = iSolutionService.getServiceById(id);
        return memo;
    }

    @PutMapping("/update")
    public ServiceeDto updateService(@RequestBody ServiceReq serviceeDtoReq) throws  EntrepriseException, ServiceeException {
        ServiceeDto memo = iSolutionService.updateService(serviceeDtoReq);
        return memo;
    }
}
