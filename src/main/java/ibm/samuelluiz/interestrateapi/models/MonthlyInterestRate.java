package ibm.samuelluiz.interestrateapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MonthlyInterestRate extends BaseInterestRate {
    @JsonProperty("Mes")
    private String month;
    @JsonProperty("anoMes")
    private String yearMonth;
    @JsonProperty("tipoModalidade")
    private String modalityType;
}
