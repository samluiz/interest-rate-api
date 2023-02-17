package ibm.samuelluiz.interestrateapi.controllers;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.services.MonthlyInterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static ibm.samuelluiz.interestrateapi.utils.ControllerUtils.generateResponse;

@RestController
@RequestMapping(value = "/taxaJurosMensal")
public class MonthlyInterestRateController {

    private final MonthlyInterestRateService service;

    @Autowired
    public MonthlyInterestRateController(MonthlyInterestRateService service) {
        this.service = service;
    }

    @GetMapping("/popular")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void populate(@RequestParam(value = "quantidade", defaultValue = "100") Integer amount) {
        service.populate(amount);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10000") Integer size,
            @RequestParam(value = "anoMes", defaultValue = "", required = false) String yearMonth) {
        Map<String, Object> response;
        PageRequest paging = PageRequest.of(page, size);

        if (!yearMonth.isBlank()) {
            Page<MonthlyInterestRate> findByYearMonth = service.findAllByYearMonth(yearMonth, paging);
            response = generateResponse(findByYearMonth);
            return ResponseEntity.ok().body(response);
        }

        Page<MonthlyInterestRate> findAll = service.findAll(paging);
        response = generateResponse(findAll);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{uuid}")
    public MonthlyInterestRate findByUUID(@PathVariable String uuid) {
        return service.findByUUID(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MonthlyInterestRate create(@RequestBody @Valid MonthlyInterestRate obj) {
        return service.create(obj);
    }

    @PutMapping("/{uuid}")
    public MonthlyInterestRate update(@RequestBody MonthlyInterestRate obj, @PathVariable String uuid) {
        return service.update(obj, uuid);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String uuid) {
        service.delete(uuid);
    }
}
