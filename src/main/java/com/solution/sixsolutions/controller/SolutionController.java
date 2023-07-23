package com.solution.sixsolutions.controller;

import com.solution.sixsolutions.dto.SolutionDto;
import com.solution.sixsolutions.dto.req.SolutionReq;
import com.solution.sixsolutions.exception.ServiceeException;
import com.solution.sixsolutions.exception.SolutionException;
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
@RequestMapping("/sixsolution/solution")
@AllArgsConstructor
public class SolutionController {

    SolutionServiceImpl iSolutionService;
    @PostMapping("/add")
    public SolutionDto saveSolution(@RequestBody SolutionReq solutionReq) throws ServiceeException, SolutionException {
        SolutionDto solution = iSolutionService.saveSolution(solutionReq);
        return solution;
    }

    @GetMapping("{id}")
    public SolutionDto getSolutionById(@PathVariable(value = "id") Long id) throws  SolutionException {
        SolutionDto memo = iSolutionService.getSolutionById(id);
        return memo;
    }

    @PutMapping("/update")
    public SolutionDto updateSolution(@RequestBody SolutionReq solutionReq) throws ServiceeException, SolutionException {
        SolutionDto memo = iSolutionService.updateSolution(solutionReq);
        return memo;
    }

}
