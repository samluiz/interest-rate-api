package ibm.samuelluiz.interestrateapi.models.dtos;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyInterestRateDTO {

    private String Modalidade;
    private Integer Posicao;
    private String InstituicaoFinanceira;
    private Double TaxaJurosAoMes;
    private Double taxaJurosAoAno;
    private String cnpj8;
    private String Mes;
    private String anoMes;

    public MonthlyInterestRate convertToEntity(MonthlyInterestRate entity) {
        entity.set_modality(getModalidade());
        entity.set_position(getPosicao());
        entity.set_financialInstitution(getInstituicaoFinanceira());
        entity.set_interestRateByMonth(getTaxaJurosAoMes());
        entity.set_interestRateByYear(getTaxaJurosAoAno());
        entity.set_eightDigitsCnpj(getCnpj8());
        entity.set_month(getMes());
        entity.set_yearMonth(getAnoMes());
        return entity;
    }
}
