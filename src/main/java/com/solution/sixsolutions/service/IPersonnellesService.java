package com.solution.sixsolutions.service;

import com.solution.sixsolutions.dto.req.RScientifiqueReq;
import com.solution.sixsolutions.entity.Personnelles;
import com.solution.sixsolutions.entity.Stagaire;
import com.solution.sixsolutions.exception.PersonnellesException;
import com.solution.sixsolutions.exception.RScientifiqueException;
import com.solution.sixsolutions.dto.PersonnellesDto;
import com.solution.sixsolutions.dto.RScientifiqueDto;
import com.solution.sixsolutions.dto.StagaireDto;
import com.solution.sixsolutions.entity.RScientifique;
import org.springframework.data.domain.Page;

public interface IPersonnellesService {
    //Personnelles

    PersonnellesDto savePersonnelles(PersonnellesDto personnellesDto) throws PersonnellesException;
    PersonnellesDto updatePersonnelles(PersonnellesDto personnellesDto) throws PersonnellesException;
    PersonnellesDto getPersonnellesById(Long idPersonnelles) throws PersonnellesException;
    Page<Personnelles> getAllPersonnelles(int page, int size);

    //Stagaire

    StagaireDto saveStagaire(StagaireDto stagaireDto) throws PersonnellesException;
    StagaireDto updateStagaire(StagaireDto stagaireDto) throws PersonnellesException;
    StagaireDto getStagaireById(Long idStagaire) throws PersonnellesException;
    Page<Stagaire> getAllStagaire(int page, int size);

    //RScientifique

    RScientifiqueDto saveRScientifique(RScientifiqueReq rScientifiqueReq) throws RScientifiqueException,PersonnellesException;
    RScientifiqueDto updateRScientifique(RScientifiqueReq rScientifiqueReq) throws RScientifiqueException,PersonnellesException;
    RScientifiqueDto getRScientifiqueById(Long idRScientifique) throws RScientifiqueException;
    Page<RScientifique> getAllRScientifique(int page, int size);


}
