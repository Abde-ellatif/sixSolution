package service;

import dto.PersonnellesDto;
import dto.RScientifiqueDto;
import dto.StagaireDto;
import dto.req.RScientifiqueReq;
import entity.Personne;
import entity.Personnelles;
import entity.RScientifique;
import entity.Stagaire;
import exception.PersonnellesException;
import exception.RScientifiqueException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPersonnellesService {
    //Personne


//    Personne savePersonne(Personne personne) throws PersonnellesException;
//    Personne updatePersonne(Personne personne) throws PersonnellesException;
//    Personne getPersonneById(Long idPersonne) throws PersonnellesException;
//    Page<Personne> getAllPersonne(int page, int size);

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
