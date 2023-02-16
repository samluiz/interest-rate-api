package ibm.samuelluiz.interestrateapi.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DailyInterestRate {
    private Date startDate;
    private Date endDate;
    private String segmentCode;
    private String segment;
    private String modalityCode;
    private String modality;
    private Integer position;
    private String financialInstitution;
    private Double interestRateByMonth;
    private Double interestRateByYear;
    private String eightDigitsCnpj;
}
