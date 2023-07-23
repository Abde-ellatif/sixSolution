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

import com.solution.sixsolutions.mapper.ISolutionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.solution.sixsolutions.repository.EntrepriseRepo;
import com.solution.sixsolutions.repository.ServiceRepo;
import com.solution.sixsolutions.repository.SolutionRepo;


import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
@Slf4j
public class SolutionServiceImpl implements ISolutionService {


    ISolutionMapper solutionMapper;
    EntrepriseRepo entrepriseRepo;
    private static String entrepriseNotFound="entreprise not found";
    private static String serviceNotFound="Service not found";


    @Override
    public EntrepriseDto saveEntreprise (EntrepriseDto entrepriseDto) throws EntrepriseException {
            Entreprise save = entrepriseRepo.save(solutionMapper.fromEntrepriseDTO(entrepriseDto));
            return solutionMapper.fromEntreprise(save);
        }


    @Override
    public EntrepriseDto updateEntreprise (EntrepriseDto entrepriseDto) throws EntrepriseException {
        Entreprise entreprise = entrepriseRepo.findById(entrepriseDto.getId()).orElse(null);
        if (entreprise==null)
                throw new EntrepriseException(entrepriseNotFound);
            Entreprise save = entrepriseRepo.save(solutionMapper.fromEntrepriseDTO(entrepriseDto));
            return solutionMapper.fromEntreprise(save);
        }

    @Override
    public EntrepriseDto getEntrepriseById (Long idEntreprise) throws EntrepriseException {
        Entreprise entreprise = entrepriseRepo.findById(idEntreprise).orElseThrow(() ->
                new EntrepriseException(entrepriseNotFound));
        EntrepriseDto entrepriseDto= solutionMapper.fromEntreprise(entreprise);
            return entrepriseDto;
        }

    @Override
    public Page<Entreprise> getAllEntreprise ( int page, int size){
            return entrepriseRepo.findAll(PageRequest.of(page, size));
        }

    @Override
    public void deleteEntrepriseById (Long idEntreprise) throws EntrepriseException {
            Entreprise entreprise=entrepriseRepo.findById(idEntreprise).orElse(null);
            if (entreprise==null)
                throw  new EntrepriseException(entrepriseNotFound);
            entrepriseRepo.deleteById(idEntreprise);
        }


    ServiceRepo serviceRepo;
    @Override
    public ServiceeDto saveService (ServiceReq serviceReq) throws ServiceeException,EntrepriseException {
        Optional<Entreprise> entreprise = entrepriseRepo.findById(serviceReq.getEntrepriseId());
        if(entreprise.isPresent()) {
            ServiceeDto serviceeDto = new ServiceeDto();
            serviceeDto.setNameService(serviceReq.getNameService());
            serviceeDto.setDescription(serviceReq.getDescription());
            serviceeDto.setImage(serviceReq.getImage());
            serviceeDto.setEntrepriseDto(solutionMapper.fromEntreprise(entreprise.get()));
            Servicee save = serviceRepo.save(solutionMapper.fromServieDTO(serviceeDto));
            return solutionMapper.fromService(save);
        }
        else
        {
            throw new EntrepriseException(entrepriseNotFound);
        }

    }

    @Override
    public ServiceeDto updateService (ServiceReq serviceReq) throws ServiceeException,EntrepriseException{
        Servicee servicee = serviceRepo.findById(serviceReq.getId()).orElse(null);

        if(servicee==null){
            throw new ServiceeException(serviceNotFound);
        }else{
            Optional<Entreprise> entreprise = entrepriseRepo.findById(serviceReq.getEntrepriseId());
            if(entreprise.isPresent())
            {
                ServiceeDto serviceeDto=new ServiceeDto();
                serviceeDto.setNameService(serviceReq.getNameService());
                serviceeDto.setDescription(serviceReq.getDescription());
                serviceeDto.setImage(serviceReq.getImage());
                serviceeDto.setEntrepriseDto(solutionMapper.fromEntreprise(entreprise.get()));
                Servicee save = serviceRepo.save(solutionMapper.fromServieDTO(serviceeDto));
                return solutionMapper.fromService(save);
            }
            else
            {
                throw new EntrepriseException(entrepriseNotFound);
            }
        }
    }

    @Override
    public ServiceeDto getServiceById (Long idService) throws ServiceeException {
        Servicee servicee = serviceRepo.findById(idService).orElseThrow(() ->
                new org.hibernate.service.spi.ServiceException(serviceNotFound));
        ServiceeDto serviceeDto= solutionMapper.fromService(servicee);
        return serviceeDto;
        }

    @Override
    public Page<Servicee> getAllService ( int page, int size){
        return serviceRepo.findAll(PageRequest.of(page, size));
        }

        SolutionRepo solutionRepo;
    @Override
    public SolutionDto saveSolution (SolutionReq solutionReq) throws SolutionException, ServiceeException {
        Optional<Servicee> servicee = serviceRepo.findById(solutionReq.getServiceId());

        if(servicee.isPresent())
        {
            SolutionDto solutionDto=new SolutionDto();
            solutionDto.setSolutionName(solutionReq.getSolutionName());
            solutionDto.setDescription(solutionReq.getDescription());
            solutionDto.setTools(solutionReq.getTools());
            solutionDto.setServiceeDto(solutionMapper.fromService(servicee.get()));
            Solution save = solutionRepo.save(solutionMapper.fromSolutionDTO(solutionDto));
            return solutionMapper.fromSolution(save);
        } else {
            throw new ServiceeException(serviceNotFound);
        }
    }

    @Override
    public SolutionDto updateSolution (SolutionReq solutionReq) throws SolutionException, ServiceeException {
        Solution solution = solutionRepo.findById(solutionReq.getServiceId()).orElse(null);

        if(solution==null){
            throw new SolutionException(serviceNotFound);
        }else{
            Optional<Servicee> servicee = serviceRepo.findById(solutionReq.getId());

            if(servicee.isPresent())
            {
                SolutionDto solutionDto=new SolutionDto();
                solutionDto.setSolutionName(solutionReq.getSolutionName());
                solutionDto.setDescription(solutionReq.getDescription());
                solutionDto.setTools(solutionReq.getTools());
                solutionDto.setServiceeDto(solutionMapper.fromService(servicee.get()));
                Solution save = solutionRepo.save(solutionMapper.fromSolutionDTO(solutionDto));
                return solutionMapper.fromSolution(save);
            } else {
                throw new ServiceeException("Service not found");
            }
        }
    }

    @Override
    public SolutionDto getSolutionById (Long idSolution) throws SolutionException {
        Solution solution = solutionRepo.findById(idSolution).orElseThrow(() ->
                new org.hibernate.service.spi.ServiceException("La solution est introuvale"));
        SolutionDto solutionDto= solutionMapper.fromSolution(solution);
        return solutionDto;
    }

    @Override
    public Page<Solution> getAllSolution ( int page, int size){
        return solutionRepo.findAll(PageRequest.of(page, size));
        }


}
