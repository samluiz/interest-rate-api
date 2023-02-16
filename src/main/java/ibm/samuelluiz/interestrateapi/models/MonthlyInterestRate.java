package ibm.samuelluiz.interestrateapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MONTHLY_INTEREST_RATE")
public class MonthlyInterestRate {

    @Id
    @UuidGenerator
    private UUID id;
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
    @JsonProperty("Mes")
    private String month;
    @JsonProperty("anoMes")
    private String yearMonth;
}
