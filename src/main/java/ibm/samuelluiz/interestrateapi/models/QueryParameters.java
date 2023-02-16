package ibm.samuelluiz.interestrateapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class QueryParameters {
    @JsonProperty("codigoSegmento")
    private String segmentCode;
    @JsonProperty("segmento")
    private String segment;
    @JsonProperty("codigoModalidade")
    private String modalityCode;
    @JsonProperty("modalidade")
    private String modality;
    @JsonProperty("tipoModalidade")
    private String modalityType;
}
