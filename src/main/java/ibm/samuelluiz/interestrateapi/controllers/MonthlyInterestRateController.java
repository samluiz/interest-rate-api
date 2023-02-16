package ibm.samuelluiz.interestrateapi.controllers;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.services.MonthlyInterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/monthly")
public class MonthlyInterestRateController {

    private final MonthlyInterestRateService service;

    @Autowired
    public MonthlyInterestRateController(MonthlyInterestRateService service) {
        this.service = service;
    }

    @GetMapping("/populate")
    public List<MonthlyInterestRate> populate(@RequestParam(value = "limit", defaultValue = "100") Integer limit) {
        List<MonthlyInterestRate> list = service.populate(limit);
        return limit > 100 ? list.stream().limit(100).collect(Collectors.toList()) : list;
    }

    @GetMapping
    public List<MonthlyInterestRate> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1000") Integer size,
            @RequestParam(value = "year-month", defaultValue = "") String yearMonth) {
        if (!yearMonth.isBlank()) {
            return service.findAllByYearMonth(yearMonth);
        }
        return service.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{uuid}")
    public MonthlyInterestRate findByUUID(@PathVariable UUID uuid) {
        return service.findByUUID(uuid);
    }
}
