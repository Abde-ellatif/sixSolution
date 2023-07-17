package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EntrepriseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameEntreprise;
    private String description;
    @OneToOne
    @JoinColumn(name = "solutionInformationId")
    private SolutionInformationDto solutionInformationId;
}
