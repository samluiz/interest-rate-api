package ibm.samuelluiz.interestrateapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAXA_JUROS_MENSAL")
public class MonthlyInterestRate extends RepresentationModel<MonthlyInterestRate> implements Serializable {
    public static final long serialVersionUID = 77L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String _uuid;
    @JsonProperty("Modalidade")
    @NotEmpty(message = "O campo 'Modalidade' não pode ser vazio.")
    private String _modality;
    @JsonProperty("Posicao")
    @NotNull(message = "O campo 'Posicao' não pode ser nulo.")
    private Integer _position;
    @JsonProperty("InstituicaoFinanceira")
    @NotEmpty(message = "O campo 'InstituicaoFinanceira' não pode ser vazio.")
    private String _financialInstitution;
    @JsonProperty("TaxaJurosAoMes")
    @NotNull(message = "O campo 'TaxaJurosAoMes' não pode ser vazio.")
    private Double _interestRateByMonth;
    @JsonProperty("TaxaJurosAoAno")
    @NotNull(message = "O campo 'TaxaJurosAoAno' não pode ser vazio.")
    private Double _interestRateByYear;
    @JsonProperty("cnpj8")
    @NotEmpty(message = "O campo 'cnpj8' não pode ser vazio.")
    @Size(min = 8, max = 8, message = "O campo 'cnpj8' deve ter 8 dígitos.")
    @Column(length = 8)
    private String _eightDigitsCnpj;
    @JsonProperty("Mes")
    @NotEmpty
    @Size(min = 8, max = 8, message = "O campo 'Mes' deve ter 8 dígitos. ex: Ago-2003")
    @Column(length = 8)
    private String _month;
    @JsonProperty("anoMes")
    @NotEmpty
    @Size(min = 7, max = 7, message = "O campo 'anoMes' deve ter 7 dígitos. ex: 2003-08")
    @Column(length = 7)
    private String _yearMonth;
}
