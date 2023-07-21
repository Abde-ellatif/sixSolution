package com.solution.sixsolutions.service;

import com.solution.sixsolutions.exception.EntrepriseException;
import com.solution.sixsolutions.exception.ServiceException;
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
//    //Contact
//    SolutionInformationDto saveContact(SolutionInformationReq solutionInformationReq) throws SolutionInformationException, EntrepriseException;
//    SolutionInformationDto updateContact(SolutionInformationReq solutionInformationReq) throws SolutionInformationException,EntrepriseException;
//    SolutionInformationDto getContactById(Long idContact) throws SolutionInformationException;
//    void deleteContact(Long idContact) throws SolutionInformationException;
//    Page<SolutionInformation> getAllContact(int page, int size);
    //Entreprise

    EntrepriseDto saveEntreprise(EntrepriseDto entrepriseDto) throws EntrepriseException;
    EntrepriseDto updateEntreprise(EntrepriseDto entrepriseDto) throws EntrepriseException;
    EntrepriseDto getEntrepriseById(Long idEntreprise) throws EntrepriseException;
    void deleteEntrepriseById(Long idEntreprise) throws EntrepriseException;
    Page<Entreprise> getAllEntreprise(int page, int size);



    //Service

    ServiceeDto saveService(ServiceReq serviceReq) throws ServiceException,EntrepriseException;
    ServiceeDto updateService(ServiceReq serviceReq) throws ServiceException,EntrepriseException;
    ServiceeDto getServiceById(Long idService) throws ServiceException;
    Page<Servicee> getAllService(int page, int size);

    //Solution

    SolutionDto saveSolution(SolutionReq solutionReq) throws SolutionException,ServiceException;
    SolutionDto updateSolution(SolutionReq solutionReq) throws SolutionException,ServiceException;
    SolutionDto getSolutionById(Long idSolution) throws SolutionException;
    Page<Solution> getAllSolution(int page, int size);







}
