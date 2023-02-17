package ibm.samuelluiz.interestrateapi.controllers;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.services.MonthlyInterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;
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
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1000") Integer size,
            @RequestParam(value = "year-month", defaultValue = "", required = false) String yearMonth) {
        Map<String, Object> response = new HashMap<>();
        PageRequest paging = PageRequest.of(page, size);

        if (!yearMonth.isBlank()) {
            Page<MonthlyInterestRate> findByYearMonth = service.findAllByYearMonth(yearMonth, paging);
            response.put("total_items", findByYearMonth.getTotalElements());
            response.put("total_pages", findByYearMonth.getTotalPages());
            response.put("current_page", findByYearMonth.getNumber());
            response.put("results", findByYearMonth.getContent());
            return ResponseEntity.ok().body(response);
        }

        Page<MonthlyInterestRate> findAll = service.findAll(paging);
        response.put("total_items", findAll.getTotalElements());
        response.put("total_pages", findAll.getTotalPages());
        response.put("current_page", findAll.getNumber());
        response.put("results", findAll.getContent());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{uuid}")
    public MonthlyInterestRate findByUUID(@PathVariable String uuid) {
        return service.findByUUID(uuid);
    }
}
