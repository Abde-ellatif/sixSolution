package com.solution.sixsolutions.dto.req;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;





@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ServiceReq {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameService;
    private String description;
    private String image;
    private Long entrepriseId;
}
