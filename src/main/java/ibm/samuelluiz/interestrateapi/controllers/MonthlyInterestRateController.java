package ibm.samuelluiz.interestrateapi.controllers;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.services.MonthlyInterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/monthly")
public class MonthlyInterestRateController {

    private MonthlyInterestRateService service;

    @Autowired
    public MonthlyInterestRateController(MonthlyInterestRateService service) {
        this.service = service;
    }

    @GetMapping("/populate")
    public void populate(@RequestParam Optional<Integer> limit) {
        service.populate(limit);
    }
}
