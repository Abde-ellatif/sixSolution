package com.solution.sixsolutions.dto;


//import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@DiscriminatorValue("personnelle")
public class PersonnellesDto extends PersonneDto {
    private String niveau;
    private String Profession;
}
