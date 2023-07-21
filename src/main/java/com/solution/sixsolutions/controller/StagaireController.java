package com.solution.sixsolutions.controller;

import com.solution.sixsolutions.dto.EntrepriseDto;
import com.solution.sixsolutions.dto.StagaireDto;
import com.solution.sixsolutions.exception.EntrepriseException;
import com.solution.sixsolutions.exception.PersonnellesException;
import com.solution.sixsolutions.mapper.IPersonnellesMapper;
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
@RequestMapping("/sixsolution/stagaire")
public class StagaireController {
    IPersonnellesService iPersonnellesService;
    @PostMapping("/add")
    public StagaireDto saveStagaire(@RequestBody StagaireDto stagaireDto) throws PersonnellesException {
        StagaireDto memo = iPersonnellesService.saveStagaire(stagaireDto);

        return memo;
    }

    @GetMapping("{id}")
    public StagaireDto getStagaireById(@PathVariable(value = "id") Long id) throws PersonnellesException {
        StagaireDto memo = iPersonnellesService.getStagaireById(id);
        return memo;
    }

    @PutMapping("/update")
    public StagaireDto updateStagaire(@RequestBody StagaireDto stagaireDto) throws PersonnellesException{
        StagaireDto memo = iPersonnellesService.updateStagaire(stagaireDto);
        return memo;
    }
}
