package com.solution.sixsolutions.service;

import com.solution.sixsolutions.exception.PersonnellesException;
import com.solution.sixsolutions.exception.RScientifiqueException;
import com.solution.sixsolutions.dto.PersonnellesDto;
import com.solution.sixsolutions.dto.RScientifiqueDto;

import com.solution.sixsolutions.dto.StagaireDto;
import com.solution.sixsolutions.dto.req.RScientifiqueReq;
import com.solution.sixsolutions.entity.Personnelles;
import com.solution.sixsolutions.entity.RScientifique;
import com.solution.sixsolutions.entity.Stagaire;
import com.solution.sixsolutions.mapper.IPersonnellesMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.solution.sixsolutions.mapper.PersonnellesMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.solution.sixsolutions.repository.PersonnellesRepo;
import com.solution.sixsolutions.repository.RScientifiqueRepo;
import com.solution.sixsolutions.repository.StagaireRepo;
import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
@Slf4j
public class PersonnellesServiceImp implements IPersonnellesService{
    IPersonnellesMapper personnellesMapper;
    PersonnellesRepo personnellesRepo;
    @Override
    public PersonnellesDto savePersonnelles(PersonnellesDto personnellesDto) throws PersonnellesException {
        Personnelles save = personnellesRepo.save(personnellesMapper.fromPersonnellesDTO(personnellesDto));
        return personnellesMapper.fromPersonnelles(save);
    }

    @Override
    public PersonnellesDto updatePersonnelles(PersonnellesDto personnellesDto) throws PersonnellesException {
        Personnelles personnelles = personnellesRepo.findById(personnellesDto.getId()).orElse(null);
        if (personnelles==null)
            throw new PersonnellesException("l'entreprise que vous voulez modifier est introuvable");
        Personnelles save = personnellesRepo.save(personnellesMapper.fromPersonnellesDTO(personnellesDto));
        return personnellesMapper.fromPersonnelles(save);
    }


    @Override
    public PersonnellesDto getPersonnellesById(Long idPersonnelles) throws PersonnellesException {
        Personnelles personnelles = personnellesRepo.findById(idPersonnelles).orElseThrow(() -> {
            return new PersonnellesException("SolutionInformation not found");
        });
        PersonnellesDto personnellesDto= personnellesMapper.fromPersonnelles(personnelles);
        return personnellesDto;
    }

    @Override
    public Page<Personnelles> getAllPersonnelles(int page, int size) {
        return personnellesRepo.findAll(PageRequest.of(page, size));
    }

    StagaireRepo stagaireRepo;
    @Override
    public StagaireDto saveStagaire(StagaireDto stagaireDto) throws PersonnellesException {
        Stagaire save = stagaireRepo.save(personnellesMapper.fromStagaireDTO(stagaireDto));
        return personnellesMapper.fromStagaire(save);
    }

    @Override
    public StagaireDto updateStagaire(StagaireDto stagaireDto) throws PersonnellesException {
        Stagaire stagaire = stagaireRepo.findById(stagaireDto.getId()).orElse(null);
        if (stagaire==null)
            throw new PersonnellesException("l'entreprise que vous voulez modifier est introuvable");
        Stagaire save = stagaireRepo.save(personnellesMapper.fromStagaireDTO(stagaireDto));
        return personnellesMapper.fromStagaire(save);
    }

    @Override
    public StagaireDto getStagaireById(Long idStagaire) throws PersonnellesException {
        Stagaire stagaire = stagaireRepo.findById(idStagaire).orElseThrow(() -> {
            return new PersonnellesException("Stagire not found");
        });
        StagaireDto stagaireDto= personnellesMapper.fromStagaire(stagaire);
        return stagaireDto;
    }

    @Override
    public Page<Stagaire> getAllStagaire(int page, int size) {
        return stagaireRepo.findAll(PageRequest.of(page, size));
    }

    RScientifiqueRepo rScientifiqueRepo;

    @Override
    public RScientifiqueDto saveRScientifique(RScientifiqueReq rScientifiqueReq) throws RScientifiqueException, PersonnellesException {
        Optional<Personnelles> personnelles = personnellesRepo.findById(rScientifiqueReq.getPersonnellesId());
        if(personnelles.isPresent())
        {
            RScientifiqueDto rScientifiqueDto=new RScientifiqueDto();
            rScientifiqueDto.setTitre(rScientifiqueReq.getTitre());
            rScientifiqueDto.setDescription(rScientifiqueReq.getDescription());
            rScientifiqueDto.setType(rScientifiqueReq.getType());
            rScientifiqueDto.setDateDeRealisation(rScientifiqueReq.getDateDeRealisation());
            rScientifiqueDto.setPersonnellesDto(personnellesMapper.fromPersonnelles(personnelles.get()));
            RScientifique save = rScientifiqueRepo.save(personnellesMapper.fromRScientifiqueDTO(rScientifiqueDto));
            return personnellesMapper.fromRScientifique(save);
        }
        else
        {
            throw new PersonnellesException("Personnelles not found");
        }
    }

    @Override
    public RScientifiqueDto updateRScientifique(RScientifiqueReq rScientifiqueReq) throws RScientifiqueException,PersonnellesException {
        RScientifique rScientifique = rScientifiqueRepo.findById(rScientifiqueReq.getPersonnellesId()).orElse(null);

        if(rScientifique==null){
            throw new RScientifiqueException("Bourse not found");
        }else{
            Optional<Personnelles> personnelles = personnellesRepo.findById(rScientifiqueReq.getPersonnellesId());
            if(personnelles.isPresent())
            {
                RScientifiqueDto rScientifiqueDto=new RScientifiqueDto();
                rScientifiqueDto.setTitre(rScientifiqueReq.getTitre());
                rScientifiqueDto.setDescription(rScientifiqueReq.getDescription());
                rScientifiqueDto.setType(rScientifiqueReq.getType());
                rScientifiqueDto.setDateDeRealisation(rScientifiqueReq.getDateDeRealisation());
                rScientifiqueDto.setPersonnellesDto(personnellesMapper.fromPersonnelles(personnelles.get()));
                RScientifique save = rScientifiqueRepo.save(personnellesMapper.fromRScientifiqueDTO(rScientifiqueDto));
                return personnellesMapper.fromRScientifique(save);
            }
            else
            {
                throw new PersonnellesException("Personnelles not found");
            }
        }
    }

    @Override
    public RScientifiqueDto getRScientifiqueById(Long idRScientifique) throws RScientifiqueException {
        RScientifique rScientifique = rScientifiqueRepo.findById(idRScientifique).orElseThrow(() -> {
            return new RScientifiqueException("Recherche Scientifique not found");
        });
        RScientifiqueDto rScientifiqueDto = personnellesMapper.fromRScientifique(rScientifique);
        return rScientifiqueDto;
    }

    @Override
    public Page<RScientifique> getAllRScientifique(int page, int size) {
        return rScientifiqueRepo.findAll(PageRequest.of(page,size));
    }
}
