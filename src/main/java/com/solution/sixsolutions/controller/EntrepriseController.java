package com.solution.sixsolutions.controller;

import com.solution.sixsolutions.dto.EntrepriseDto;
import com.solution.sixsolutions.exception.EntrepriseException;
import com.solution.sixsolutions.service.ISolutionService;
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
@RequestMapping("/sixsolution/entreprise")
public class EntrepriseController {
    ISolutionService iSolutionService;
    @PostMapping("/add")
    public EntrepriseDto saveEntreprise(@RequestBody EntrepriseDto entrepriseDto) throws EntrepriseException {
        EntrepriseDto memo = iSolutionService.saveEntreprise(entrepriseDto);

        return memo;
    }

    @GetMapping("{id}")
    public EntrepriseDto getEntrepriseById(@PathVariable(value = "id") Long id) throws EntrepriseException{
        EntrepriseDto memo = iSolutionService.getEntrepriseById(id);
        return memo;
    }

    @PutMapping("/update")
    public EntrepriseDto updateEntreprise(@RequestBody EntrepriseDto entrepriseDto) throws EntrepriseException{
        EntrepriseDto memo = iSolutionService.updateEntreprise(entrepriseDto);
        return memo;
    }


}
