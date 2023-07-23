package com.solution.sixsolutions.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ServiceeDto  {
    private Long id;
    private String nameService;
    private String description;
    private String image;
    private EntrepriseDto entrepriseDto;
}
