package ibm.samuelluiz.interestrateapi.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class MonthlyInterestRateList {
    @JsonProperty("value")
    private Set<MonthlyInterestRateDTO> results;

    public Set<MonthlyInterestRate> getResults() {
        return this.results.stream()
                .map(MonthlyInterestRateDTO::convertToEntity)
                .collect(Collectors.toSet());
    }
}
