package com.solution.sixsolutions.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EntrepriseDto {
    private Long id;
    private String nameEntreprise;
    private String description;
    private String siegeSocial1;
    private String siegeSocial2;
    private String email;
    private String telephone;
    private String fix;
    private String fax;
}
