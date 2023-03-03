package ibm.samuelluiz.interestrateapi.common;

import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://olinda.bcb.gov.br/olinda/servico/taxaJuros/versao/v2/odata", name = "test")
public interface TestClient {
    @GetMapping("/TaxasJurosMensalPorMes")
    MonthlyInterestRateList populate();
}