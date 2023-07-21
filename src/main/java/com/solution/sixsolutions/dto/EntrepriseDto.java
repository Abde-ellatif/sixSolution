package com.solution.sixsolutions.dto;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EntrepriseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameEntreprise;
    private String description;
    private String siegeSocial1;
    private String siegeSocial2;
    private String email;
    private String telephone;
    private String fix;
    private String fax;
    //private SolutionInformationDto solutionInformationId;
}
