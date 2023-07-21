package com.solution.sixsolutions.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RScientifiqueDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String description;
    private String type;
    private Date dateDeRealisation;
    @ManyToOne
    @JoinColumn(name = "personnelles_Id")
    private PersonnellesDto personnellesDto;

}
