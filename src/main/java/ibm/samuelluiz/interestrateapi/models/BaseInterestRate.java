package ibm.samuelluiz.interestrateapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseInterestRate {

    @JsonProperty("Modalidade")
    private String modality;
    @JsonProperty("Posicao")
    private Integer position;
    @JsonProperty("InstituicaoFinanceira")
    private String financialInstitution;
    @JsonProperty("TaxaJurosAoMes")
    private Double interestRateByMonth;
    @JsonProperty("TaxaJurosAoAno")
    private Double interestRateByYear;
    @JsonProperty("cnpj8")
    private String eightDigitsCnpj;
}
