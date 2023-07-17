package service;

import dto.EntrepriseDto;
import dto.ServiceeDto;
import dto.SolutionDto;
import dto.SolutionInformationDto;
import dto.req.ServiceReq;
import dto.req.SolutionInformationReq;
import dto.req.SolutionReq;
import entity.SolutionInformation;
import entity.Entreprise;
import entity.RScientifique;
import entity.Servicee;
import entity.Solution;
import exception.SolutionInformationException;
import exception.EntrepriseException;
import exception.RScientifiqueException;
import exception.ServiceException;
import exception.SolutionException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISolutionService {
    //Contact
    SolutionInformationDto saveContact(SolutionInformationReq solutionInformationReq) throws SolutionInformationException,EntrepriseException;
    SolutionInformationDto updateContact(SolutionInformationReq solutionInformationReq) throws SolutionInformationException,EntrepriseException;
    SolutionInformationDto getContactById(Long idContact) throws SolutionInformationException;
    void deleteContact(Long idContact) throws SolutionInformationException;
    Page<SolutionInformation> getAllContact(int page, int size);
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
