package com.solution.sixsolutions.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PersonneDto {
    private Long id;
    private String name;
    private String prenom;
    private Date dateNaissance;
    private String image;
    private String tele;
    private String email;
}
