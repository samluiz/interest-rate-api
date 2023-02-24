package ibm.samuelluiz.interestrateapi.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyInterestRateDTO {

    @JsonProperty("Modalidade")
    private String modalidade;

    @JsonProperty("Posicao")
    private Integer posicao;

    @JsonProperty("InstituicaoFinanceira")
    private String instituicaoFinanceira;

    @JsonProperty("TaxaJurosAoMes")
    private Double taxaJurosAoMes;

    @JsonProperty("TaxaJurosAoAno")
    private Double taxaJurosAoAno;

    @JsonProperty("cnpj8")
    private String cnpj8;

    @JsonProperty("Mes")
    private String mes;

    @JsonProperty("anoMes")
    private String anoMes;

    public MonthlyInterestRate convertToEntity() {
        MonthlyInterestRate entity = new MonthlyInterestRate();
        entity.set_modality(this.modalidade);
        entity.set_position(this.posicao);
        entity.set_financialInstitution(this.instituicaoFinanceira);
        entity.set_interestRateByMonth(this.taxaJurosAoMes);
        entity.set_interestRateByYear(this.taxaJurosAoAno);
        entity.set_eightDigitsCnpj(this.cnpj8);
        entity.set_month(this.mes);
        entity.set_yearMonth(this.anoMes);
        return entity;
    }
}
