package ibm.samuelluiz.interestrateapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Dates {
    @JsonProperty("inicioPeriodo")
    private String startDate;
    @JsonProperty("fimPeriodo")
    private String endDate;
}
