package com.solution.sixsolutions.controller;

import com.solution.sixsolutions.dto.RScientifiqueDto;
import com.solution.sixsolutions.dto.req.RScientifiqueReq;
import com.solution.sixsolutions.exception.PersonnellesException;
import com.solution.sixsolutions.exception.RScientifiqueException;
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
@RequestMapping("/sixsolution/rscientifique")
public class RScientifiqueController {
    IPersonnellesService iPersonnellesService;
    @PostMapping("/add")
    public RScientifiqueDto saveRScientifique(@RequestBody RScientifiqueReq rScientifiqueReq) throws PersonnellesException, RScientifiqueException {
        RScientifiqueDto memo = iPersonnellesService.saveRScientifique(rScientifiqueReq);

        return memo;
    }

    @GetMapping("{id}")
    public RScientifiqueDto getRScientifiqueById(@PathVariable(value = "id") Long id) throws  RScientifiqueException {
        RScientifiqueDto memo = iPersonnellesService.getRScientifiqueById(id);
        return memo;
    }

    @PutMapping("/update")
    public RScientifiqueDto updateRScientifique(@RequestBody RScientifiqueReq rScientifiqueReq) throws RScientifiqueException, PersonnellesException {
        RScientifiqueDto memo = iPersonnellesService.updateRScientifique(rScientifiqueReq);
        return memo;
    }
}
