package com.solution.sixsolutions.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SolutionDto {
    private Long id;
    private String solutionName;
    private String description;
    private String tools;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRealisation;
    private ServiceeDto serviceeDto;
}
