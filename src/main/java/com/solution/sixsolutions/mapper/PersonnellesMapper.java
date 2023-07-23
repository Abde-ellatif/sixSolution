package com.solution.sixsolutions.mapper;

import com.solution.sixsolutions.dto.PersonnellesDto;
import com.solution.sixsolutions.dto.RScientifiqueDto;
import com.solution.sixsolutions.dto.StagaireDto;
import com.solution.sixsolutions.entity.Personnelles;
import com.solution.sixsolutions.entity.RScientifique;
import com.solution.sixsolutions.entity.Stagaire;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PersonnellesMapper implements IPersonnellesMapper{




    @Override
    public PersonnellesDto fromPersonnelles(Personnelles personnelles) {
        PersonnellesDto personnellesDto=new PersonnellesDto();
        BeanUtils.copyProperties(personnelles,personnellesDto);
        return personnellesDto;
    }

    @Override
    public Personnelles fromPersonnellesDTO(PersonnellesDto personnellesDto) {
        Personnelles personnelles=new Personnelles();
        BeanUtils.copyProperties(personnellesDto,personnelles);
        return personnelles;
    }

    @Override
    public StagaireDto fromStagaire(Stagaire stagaire) {
        StagaireDto stagaireDto=new StagaireDto();
        BeanUtils.copyProperties(stagaire,stagaireDto);
        return  stagaireDto;
    }

    @Override
    public Stagaire fromStagaireDTO(StagaireDto stagaireDto) {
        Stagaire stagaire= new Stagaire();
        BeanUtils.copyProperties(stagaireDto,stagaire);
        return stagaire;
    }

    @Override
    public RScientifiqueDto fromRScientifique(RScientifique rScientifique) {
        RScientifiqueDto rScientifiqueDto=new RScientifiqueDto();
        BeanUtils.copyProperties(rScientifique,rScientifiqueDto);
        rScientifiqueDto.setPersonnellesDto(this.fromPersonnelles(rScientifique.getPersonnelles()));
        return rScientifiqueDto;
    }

    @Override
    public RScientifique fromRScientifiqueDTO(RScientifiqueDto rScientifiqueDto) {
        RScientifique rScientifique=new RScientifique();
        BeanUtils.copyProperties(rScientifiqueDto,rScientifique);
        rScientifique.setPersonnelles(this.fromPersonnellesDTO(rScientifiqueDto.getPersonnellesDto()));
        return rScientifique;
    }

}
