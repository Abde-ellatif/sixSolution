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
import entity.Servicee;
import entity.Solution;

import exception.SolutionInformationException;
import exception.EntrepriseException;
import exception.ServiceException;
import exception.SolutionException;
//import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.SolutionMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.EntrepriseRepo;
import repository.ServiceRepo;
import repository.SolutionInformationRepo;
import repository.SolutionRepo;


import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
@Slf4j
public class SolutionServiceImpl implements ISolutionService {

    SolutionInformationRepo solutionInformationRepo;
    SolutionMapper solutionMapper;
    EntrepriseRepo entrepriseRepo;

    @Override
    public SolutionInformationDto saveContact(SolutionInformationReq solutionInformationReq) throws SolutionInformationException, EntrepriseException {
        Optional<Entreprise> entreprise = entrepriseRepo.findById(solutionInformationReq.getEntrepriseId());
        if (entreprise.isPresent()) {
            SolutionInformationDto solutionInformationDto = new SolutionInformationDto();
            solutionInformationDto.setSiegeSocial1(solutionInformationReq.getSiegeSocial1());
            solutionInformationDto.setSiegeSocial2(solutionInformationReq.getSiegeSocial2());
            solutionInformationDto.setEmail(solutionInformationReq.getEmail());
            solutionInformationDto.setTelephone(solutionInformationReq.getTelephone());
            solutionInformationDto.setFix(solutionInformationReq.getFix());
            solutionInformationDto.setFax(solutionInformationReq.getFax());
            solutionInformationDto.setEntrepriseId(solutionMapper.fromEntreprise(entreprise.get()));
            SolutionInformation save = solutionInformationRepo.save(solutionMapper.fromSolutionInformationDTO(solutionInformationDto));
            return solutionMapper.fromSolutionInformation(save);
        } else {
            throw new EntrepriseException("Entreprise not found");
        }
    }

    @Override
    public SolutionInformationDto updateContact(SolutionInformationReq solutionInformationReq) throws SolutionInformationException, EntrepriseException {
        SolutionInformation solutionInformation = solutionInformationRepo.findById(solutionInformationReq.getId()).orElse(null);

        if (solutionInformation == null) {
            throw new SolutionInformationException("SolutionInformation not found");
        } else {
            Optional<Entreprise> entreprise = entrepriseRepo.findById(solutionInformationReq.getEntrepriseId());
            if (entreprise.isPresent()) {
                SolutionInformationDto solutionInformationDto = new SolutionInformationDto();
                solutionInformationDto.setSiegeSocial1(solutionInformationReq.getSiegeSocial1());
                solutionInformationDto.setSiegeSocial2(solutionInformationReq.getSiegeSocial2());
                solutionInformationDto.setEmail(solutionInformationReq.getEmail());
                solutionInformationDto.setTelephone(solutionInformationReq.getTelephone());
                solutionInformationDto.setFix(solutionInformationReq.getFix());
                solutionInformationDto.setFax(solutionInformationReq.getFax());
                solutionInformationDto.setEntrepriseId(solutionMapper.fromEntreprise(entreprise.get()));
                SolutionInformation save = solutionInformationRepo.save(solutionMapper.fromSolutionInformationDTO(solutionInformationDto));
                return solutionMapper.fromSolutionInformation(save);
            } else {
                throw new EntrepriseException("Entreprise not found");
            }

        }
    }

    @Override
    public void deleteContact (Long idContact) throws SolutionInformationException {
            solutionInformationRepo.findById(idContact).orElseThrow(() -> {
                return new SolutionInformationException("SolutionInformation not found");
            });
            solutionInformationRepo.deleteById(idContact);
        }

    @Override
    public SolutionInformationDto getContactById (Long idContact) throws SolutionInformationException {
            SolutionInformation solutionInformation = solutionInformationRepo.findById(idContact).orElseThrow(() -> {
                return new SolutionInformationException("SolutionInformation not found");
            });
            SolutionInformationDto solutionInformationDto= solutionMapper.fromSolutionInformation(solutionInformation);
            return solutionInformationDto;
        }

    @Override
    public Page<SolutionInformation> getAllContact ( int page, int size){
            return solutionInformationRepo.findAll(PageRequest.of(page, size));
        }


    @Override
    public EntrepriseDto saveEntreprise (EntrepriseDto entrepriseDto) throws EntrepriseException {
            Entreprise save = entrepriseRepo.save(solutionMapper.fromEntrepriseDTO(entrepriseDto));
            return solutionMapper.fromEntreprise(save);
        }


    @Override
    public EntrepriseDto updateEntreprise (EntrepriseDto entrepriseDto) throws EntrepriseException {
        Entreprise entreprise = entrepriseRepo.findById(entrepriseDto.getId()).orElse(null);
        if (entreprise==null)
                throw new EntrepriseException("l'entreprise que vous voulez modifier est introuvable");
            Entreprise save = entrepriseRepo.save(solutionMapper.fromEntrepriseDTO(entrepriseDto));
            return solutionMapper.fromEntreprise(save);
        }

    @Override
    public EntrepriseDto getEntrepriseById (Long idEntreprise) throws EntrepriseException {
        Entreprise entreprise = entrepriseRepo.findById(idEntreprise).orElseThrow(() ->
                new EntrepriseException("L'ntreprise est introuvale"));
        EntrepriseDto entrepriseDto= solutionMapper.fromEntreprise(entreprise);
            return entrepriseDto;
        }

    @Override
    public Page<Entreprise> getAllEntreprise ( int page, int size){
            return entrepriseRepo.findAll(PageRequest.of(page, size));
        }

    @Override
    public void deleteEntrepriseById (Long idEntreprise) throws EntrepriseException {
            entrepriseRepo.findById(idEntreprise).orElseThrow(() -> {
                return new EntrepriseException("l'entreprise est introuvale");
            });
            entrepriseRepo.deleteById(idEntreprise);
        }


    ServiceRepo serviceRepo;
    @Override
    public ServiceeDto saveService (ServiceReq serviceReq) throws ServiceException,EntrepriseException {
        Optional<Entreprise> entreprise = entrepriseRepo.findById(serviceReq.getId());
        if(entreprise.isPresent())
        {
            ServiceeDto serviceeDto=new ServiceeDto();
            serviceeDto.setNameService(serviceReq.getNameService());
            serviceeDto.setDescription(serviceReq.getDescription());
            serviceeDto.setImage(serviceReq.getImage());
            serviceeDto.setEntrepriseId(solutionMapper.fromEntreprise(entreprise.get()));
            Servicee save = serviceRepo.save(solutionMapper.fromServieDTO(serviceeDto));
            return solutionMapper.fromService(save);
        }
        else
        {
            throw new EntrepriseException("Entreprise not found");
        }
    }

    @Override
    public ServiceeDto updateService (ServiceReq serviceReq) throws ServiceException ,EntrepriseException{
        Servicee servicee = serviceRepo.findById(serviceReq.getId()).orElse(null);

        if(servicee==null){
            throw new ServiceException("Bourse not found");
        }else{
            Optional<Entreprise> entreprise = entrepriseRepo.findById(serviceReq.getId());
            if(entreprise.isPresent())
            {
                ServiceeDto serviceeDto=new ServiceeDto();
                serviceeDto.setNameService(serviceReq.getNameService());
                serviceeDto.setDescription(serviceReq.getDescription());
                serviceeDto.setImage(serviceReq.getImage());
                serviceeDto.setEntrepriseId(solutionMapper.fromEntreprise(entreprise.get()));
                Servicee save = serviceRepo.save(solutionMapper.fromServieDTO(serviceeDto));
                return solutionMapper.fromService(save);
            }
            else
            {
                throw new EntrepriseException("Entreprise not found");
            }
        }
        }

    @Override
    public ServiceeDto getServiceById (Long idService) throws ServiceException {
        Servicee servicee = serviceRepo.findById(idService).orElseThrow(() ->
                new org.hibernate.service.spi.ServiceException("L'ntreprise est introuvale"));
        ServiceeDto serviceeDto= solutionMapper.fromService(servicee);
        return serviceeDto;
        }

    @Override
    public Page<Servicee> getAllService ( int page, int size){
        return serviceRepo.findAll(PageRequest.of(page, size));
        }

        SolutionRepo solutionRepo;
    @Override
    public SolutionDto saveSolution (SolutionReq solutionReq) throws SolutionException,ServiceException {
        Optional<Servicee> servicee = serviceRepo.findById(solutionReq.getId());

        if(servicee.isPresent())
        {
            SolutionDto solutionDto=new SolutionDto();
            solutionDto.setSolutionName(solutionReq.getSolutionName());
            solutionDto.setDescription(solutionReq.getDescription());
            solutionDto.setTools(solutionReq.getTools());
            solutionDto.setServiceId(solutionMapper.fromService(servicee.get()));
            Solution save = solutionRepo.save(solutionMapper.fromSolutionDTO(solutionDto));
            return solutionMapper.fromSolution(save);
        } else {
            throw new ServiceException("Entreprise not found");
        }
        }

    @Override
    public SolutionDto updateSolution (SolutionReq solutionReq) throws SolutionException,ServiceException {
        Solution solution = solutionRepo.findById(solutionReq.getId()).orElse(null);

        if(solution==null){
            throw new SolutionException("Solution not found");
        }else{
            Optional<Servicee> servicee = serviceRepo.findById(solutionReq.getId());

            if(servicee.isPresent())
            {
                SolutionDto solutionDto=new SolutionDto();
                solutionDto.setSolutionName(solutionReq.getSolutionName());
                solutionDto.setDescription(solutionReq.getDescription());
                solutionDto.setTools(solutionReq.getTools());
                solutionDto.setServiceId(solutionMapper.fromService(servicee.get()));
                Solution save = solutionRepo.save(solutionMapper.fromSolutionDTO(solutionDto));
                return solutionMapper.fromSolution(save);
            } else {
                throw new ServiceException("Entreprise not found");
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
