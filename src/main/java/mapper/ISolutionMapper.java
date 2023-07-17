package mapper;

import dto.EntrepriseDto;
import dto.ServiceeDto;
import dto.SolutionDto;
import dto.SolutionInformationDto;
import entity.Entreprise;
import entity.Servicee;
import entity.Solution;
import entity.SolutionInformation;

public interface ISolutionMapper {
    EntrepriseDto fromEntreprise(Entreprise entreprise);
    Entreprise fromEntrepriseDTO(EntrepriseDto entrepriseDto);

    ServiceeDto fromService(Servicee servicee);
    Servicee fromServieDTO(ServiceeDto serviceeDto);

    SolutionDto fromSolution(Solution solution);
    Solution fromSolutionDTO(SolutionDto solutionDto);

    SolutionInformationDto fromSolutionInformation(SolutionInformation solutionInformation);
    SolutionInformation fromSolutionInformationDTO(SolutionInformationDto solutionInformationDto);
}
