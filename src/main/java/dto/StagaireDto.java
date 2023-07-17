package dto;

//import jakarta.persistence.DiscriminatorValue;
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
@DiscriminatorValue("stagaire")
public class StagaireDto extends PersonneDto {
    private String cv;
    private String typeDeStage;
    private String Sujet;
    private String description;
}
