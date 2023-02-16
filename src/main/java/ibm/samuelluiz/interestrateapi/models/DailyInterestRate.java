package ibm.samuelluiz.interestrateapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DailyInterestRate extends BaseInterestRate {

    @JsonProperty("InicioPeriodo")
    private String startDate;
    @JsonProperty("FimPeriodo")
    private String endDate;
    @JsonProperty("codigoSegmento")
    private String segmentCode;
    @JsonProperty("Segmento")
    private String segment;
    @JsonProperty("codigoModalidade")
    private String modalityCode;

}
