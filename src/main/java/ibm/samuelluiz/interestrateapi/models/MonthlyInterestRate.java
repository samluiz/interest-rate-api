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
    private UUID _uuid;
    @JsonProperty("Modalidade")
    private String _modality;
    @JsonProperty("Posicao")
    private Integer _position;
    @JsonProperty("InstituicaoFinanceira")
    private String _financialInstitution;
    @JsonProperty("TaxaJurosAoMes")
    private Double _interestRateByMonth;
    @JsonProperty("TaxaJurosAoAno")
    private Double _interestRateByYear;
    @JsonProperty("cnpj8")
    private String _eightDigitsCnpj;
    @JsonProperty("Mes")
    private String _month;
    @JsonProperty("anoMes")
    private String _yearMonth;
}
