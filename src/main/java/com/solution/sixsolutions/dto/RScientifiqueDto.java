package com.solution.sixsolutions.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RScientifiqueDto {
    private Long id;
    private String titre;
    private String description;
    private String type;
    private Date dateDeRealisation;
    private PersonnellesDto personnellesDto;

}
