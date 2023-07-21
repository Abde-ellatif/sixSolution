package com.solution.sixsolutions.mapper;

import com.solution.sixsolutions.dto.EntrepriseDto;
import com.solution.sixsolutions.dto.ServiceeDto;
import com.solution.sixsolutions.entity.Entreprise;
import com.solution.sixsolutions.entity.Servicee;
import com.solution.sixsolutions.entity.Solution;
import com.solution.sixsolutions.dto.SolutionDto;

public interface ISolutionMapper {
    EntrepriseDto fromEntreprise(Entreprise entreprise);
    Entreprise fromEntrepriseDTO(EntrepriseDto entrepriseDto);

    ServiceeDto fromService(Servicee servicee);
    Servicee fromServieDTO(ServiceeDto serviceeDto);

    SolutionDto fromSolution(Solution solution);
    Solution fromSolutionDTO(SolutionDto solutionDto);
//
//    SolutionInformationDto fromSolutionInformation(SolutionInformation solutionInformation);
//    SolutionInformation fromSolutionInformationDTO(SolutionInformationDto solutionInformationDto);
}
