package ibm.samuelluiz.interestrateapi.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyInterestRateList {
    @JsonProperty("value")
    private Collection<MonthlyInterestRate> results;
}
