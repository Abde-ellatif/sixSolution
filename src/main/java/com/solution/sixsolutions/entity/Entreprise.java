package com.solution.sixsolutions.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
