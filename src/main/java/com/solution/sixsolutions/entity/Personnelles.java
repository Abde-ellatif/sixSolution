package com.solution.sixsolutions.entity;

//import jakarta.persistence.DiscriminatorValue;
//import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@DiscriminatorValue("personnelle")
public class Personnelles extends Personne{

    private Long id;
    private String niveau;
    private String Profession;
}
