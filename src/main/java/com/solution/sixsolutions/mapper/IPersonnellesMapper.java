package com.solution.sixsolutions.mapper;

import com.solution.sixsolutions.dto.PersonnellesDto;
import com.solution.sixsolutions.dto.RScientifiqueDto;
import com.solution.sixsolutions.dto.StagaireDto;
import com.solution.sixsolutions.entity.Personnelles;
import com.solution.sixsolutions.entity.RScientifique;
import com.solution.sixsolutions.entity.Stagaire;

public interface IPersonnellesMapper {


    PersonnellesDto fromPersonnelles(Personnelles personnelles);
    Personnelles fromPersonnellesDTO(PersonnellesDto personnellesDto);

    StagaireDto fromStagaire(Stagaire stagaire);
    Stagaire fromStagaireDTO(StagaireDto stagaireDto);

    RScientifiqueDto fromRScientifique(RScientifique rScientifique);
    RScientifique fromRScientifiqueDTO(RScientifiqueDto rScientifiqueDto);
}
