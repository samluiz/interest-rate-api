package ibm.samuelluiz.interestrateapi.clients;

import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${bcb.api.baseurl}", name = "monthly")
public interface MainClient {
    @GetMapping("${bcb.api.monthly-interest-rate}?%24format=json&%24top={limit}")
    MonthlyInterestRateList populate(@PathVariable Integer limit);
}
