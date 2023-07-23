package com.solution.sixsolutions.dto.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SolutionReq {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String solutionName;
    private String description;
    private String tools;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRealisation;
    private Long serviceId;
}
