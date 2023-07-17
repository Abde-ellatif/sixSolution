package mapper;

import dto.EntrepriseDto;
import dto.ServiceeDto;
import dto.SolutionDto;
import dto.SolutionInformationDto;
import entity.Entreprise;
import entity.Servicee;
import entity.Solution;
import entity.SolutionInformation;
import org.springframework.beans.BeanUtils;

public class SolutionMapper implements ISolutionMapper{
    @Override
    public EntrepriseDto fromEntreprise(Entreprise entreprise) {
        EntrepriseDto entrepriseDto=new EntrepriseDto();
        BeanUtils.copyProperties(entreprise,entrepriseDto);
        entrepriseDto.setSolutionInformationId(this.fromSolutionInformation(entreprise.getSolutionInformationId()));
        return entrepriseDto;
    }

    @Override
    public Entreprise fromEntrepriseDTO(EntrepriseDto entrepriseDto) {
        Entreprise entreprise=new Entreprise();
        BeanUtils.copyProperties(entrepriseDto,entreprise);
        entreprise.setSolutionInformationId(this.fromSolutionInformationDTO(entrepriseDto.getSolutionInformationId()));
        return entreprise;
    }

    public ServiceeDto fromService(Servicee servicee) {
        ServiceeDto serviceeDto=new ServiceeDto();
        BeanUtils.copyProperties(servicee,serviceeDto);
        serviceeDto.setEntrepriseId(this.fromEntreprise(servicee.getEntrepriseId()));
        return serviceeDto;
    }

    @Override
    public Servicee fromServieDTO(ServiceeDto serviceeDto) {
        Servicee servicee=new Servicee();
        BeanUtils.copyProperties(serviceeDto,servicee);
        servicee.setEntrepriseId(this.fromEntrepriseDTO(serviceeDto.getEntrepriseId()));
        return null;
    }

    @Override
    public SolutionDto fromSolution(Solution solution) {
        SolutionDto solutionDto = new SolutionDto();
        BeanUtils.copyProperties(solution,solutionDto);
        solutionDto.setServiceId(this.fromService(solution.getServiceId()));
        return solutionDto;
    }

    @Override
    public Solution fromSolutionDTO(SolutionDto solutionDto) {
        Solution solution=new Solution();
        BeanUtils.copyProperties(solutionDto,solution);
        solution.setServiceId(this.fromServieDTO(solutionDto.getServiceId()));
        return solution;
    }

    @Override
    public SolutionInformationDto fromSolutionInformation(SolutionInformation solutionInformation) {
        SolutionInformationDto solutionInformationDto=new SolutionInformationDto();
        BeanUtils.copyProperties(solutionInformation,solutionInformationDto);
        return solutionInformationDto;
    }

    @Override
    public SolutionInformation fromSolutionInformationDTO(SolutionInformationDto solutionInformationDto) {
        SolutionInformation solutionInformation= new SolutionInformation();
        BeanUtils.copyProperties(solutionInformationDto,solutionInformation);
        return solutionInformation;
    }
}
