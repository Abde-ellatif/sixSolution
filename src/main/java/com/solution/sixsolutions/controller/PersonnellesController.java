package com.solution.sixsolutions.controller;

import com.solution.sixsolutions.dto.PersonnellesDto;
import com.solution.sixsolutions.exception.PersonnellesException;
import com.solution.sixsolutions.service.IPersonnellesService;
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
@RequestMapping("/sixsolution/personnelles")
public class PersonnellesController {

    IPersonnellesService iPersonnellesService;
    @PostMapping("/add")
    public PersonnellesDto savePersonnelles(@RequestBody PersonnellesDto personnellesDto) throws PersonnellesException {
        PersonnellesDto memo = iPersonnellesService.savePersonnelles(personnellesDto);

        return memo;
    }

    @GetMapping("{id}")
    public PersonnellesDto getPersonnellesById(@PathVariable(value = "id") Long id) throws PersonnellesException {
        PersonnellesDto memo = iPersonnellesService.getPersonnellesById(id);
        return memo;
    }

    @PutMapping("/update")
    public PersonnellesDto updatePersonnelles(@RequestBody PersonnellesDto personnellesDto) throws PersonnellesException{
        PersonnellesDto memo = iPersonnellesService.updatePersonnelles(personnellesDto);
        return memo;
    }
}
