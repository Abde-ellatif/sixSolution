package com.solution.sixsolutions.service;

import com.solution.sixsolutions.exception.EntrepriseException;
import com.solution.sixsolutions.exception.ServiceeException;
import com.solution.sixsolutions.exception.SolutionException;
import com.solution.sixsolutions.dto.EntrepriseDto;
import com.solution.sixsolutions.dto.ServiceeDto;
import com.solution.sixsolutions.dto.SolutionDto;
import com.solution.sixsolutions.dto.req.ServiceReq;
import com.solution.sixsolutions.dto.req.SolutionReq;
import com.solution.sixsolutions.entity.Entreprise;
import com.solution.sixsolutions.entity.Servicee;
import com.solution.sixsolutions.entity.Solution;
import org.springframework.data.domain.Page;

public interface ISolutionService {

    //Entreprise

    EntrepriseDto saveEntreprise(EntrepriseDto entrepriseDto) throws EntrepriseException;
    EntrepriseDto updateEntreprise(EntrepriseDto entrepriseDto) throws EntrepriseException;
    EntrepriseDto getEntrepriseById(Long idEntreprise) throws EntrepriseException;
    void deleteEntrepriseById(Long idEntreprise) throws EntrepriseException;
    Page<Entreprise> getAllEntreprise(int page, int size);



    //Service

    ServiceeDto saveService(ServiceReq serviceReq) throws ServiceeException,EntrepriseException;
    ServiceeDto updateService(ServiceReq serviceReq) throws ServiceeException,EntrepriseException;
    ServiceeDto getServiceById(Long idService) throws ServiceeException;
    Page<Servicee> getAllService(int page, int size);

    //Solution

    SolutionDto saveSolution(SolutionReq solutionReq) throws SolutionException, ServiceeException;
    SolutionDto updateSolution(SolutionReq solutionReq) throws SolutionException, ServiceeException;
    SolutionDto getSolutionById(Long idSolution) throws SolutionException;
    Page<Solution> getAllSolution(int page, int size);







}
