package com.solution.sixsolutions.mapper;

import com.solution.sixsolutions.dto.EntrepriseDto;
import com.solution.sixsolutions.dto.ServiceeDto;
import com.solution.sixsolutions.entity.Entreprise;
import com.solution.sixsolutions.entity.Servicee;
import com.solution.sixsolutions.entity.Solution;
import com.solution.sixsolutions.dto.SolutionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SolutionMapper implements ISolutionMapper{
    @Override
    public EntrepriseDto fromEntreprise(Entreprise entreprise) {
        EntrepriseDto entrepriseDto=new EntrepriseDto();
        BeanUtils.copyProperties(entreprise,entrepriseDto);

        return entrepriseDto;
    }

    @Override
    public Entreprise fromEntrepriseDTO(EntrepriseDto entrepriseDto) {
        Entreprise entreprise=new Entreprise();
        BeanUtils.copyProperties(entrepriseDto,entreprise);

        return entreprise;
    }

    public ServiceeDto fromService(Servicee servicee) {
        ServiceeDto serviceeDto=new ServiceeDto();
        BeanUtils.copyProperties(servicee,serviceeDto);
        serviceeDto.setEntrepriseDto(this.fromEntreprise(servicee.getEntreprise()));
        return serviceeDto;
    }

    @Override
    public Servicee fromServieDTO(ServiceeDto serviceeDto) {
        Servicee servicee=new Servicee();
        BeanUtils.copyProperties(serviceeDto,servicee);
        servicee.setEntreprise(this.fromEntrepriseDTO(serviceeDto.getEntrepriseDto()));
        return servicee;
    }

    @Override
    public SolutionDto fromSolution(Solution solution) {
        SolutionDto solutionDto = new SolutionDto();
        BeanUtils.copyProperties(solution,solutionDto);
        solutionDto.setServiceeDto(this.fromService(solution.getServicee()));
        return solutionDto;
    }

    @Override
    public Solution fromSolutionDTO(SolutionDto solutionDto) {
        Solution solution=new Solution();
        BeanUtils.copyProperties(solutionDto,solution);
        solution.setServicee(this.fromServieDTO(solutionDto.getServiceeDto()));
        return solution;
    }


}
