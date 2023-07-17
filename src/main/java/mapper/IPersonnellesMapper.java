package mapper;

import dto.PersonneDto;
import dto.PersonnellesDto;
import dto.RScientifiqueDto;
import dto.StagaireDto;
import entity.Personne;
import entity.Personnelles;
import entity.RScientifique;
import entity.Stagaire;

public interface IPersonnellesMapper {

    PersonneDto fromPersonne(Personne personne);
    Personne fromPersonneDTO(PersonneDto personneDto);

    PersonnellesDto fromPersonnelles(Personnelles personnelles);
    Personnelles fromPersonnellesDTO(PersonnellesDto personnellesDto);

    StagaireDto fromStagaire(Stagaire stagaire);
    Stagaire fromStagaireDTO(StagaireDto stagaireDto);

    RScientifiqueDto fromRScientifique(RScientifique rScientifique);
    RScientifique fromRScientifiqueDTO(RScientifiqueDto rScientifiqueDto);
}
