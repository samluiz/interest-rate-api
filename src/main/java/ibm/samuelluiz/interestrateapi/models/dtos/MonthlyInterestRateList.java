package ibm.samuelluiz.interestrateapi.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import lombok.Data;

import java.util.Collection;

@Data
public class MonthlyInterestRateList {
    @JsonProperty("value")
    private Collection<MonthlyInterestRate> results;
}
