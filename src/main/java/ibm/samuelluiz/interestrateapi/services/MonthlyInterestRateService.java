package ibm.samuelluiz.interestrateapi.services;

import ibm.samuelluiz.interestrateapi.clients.MainClient;
import ibm.samuelluiz.interestrateapi.exceptions.services.InvalidQueryException;
import ibm.samuelluiz.interestrateapi.exceptions.services.ResourceNotFoundException;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static ibm.samuelluiz.interestrateapi.utils.ServiceUtils.getNullPropertyNames;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class MonthlyInterestRateService {

    private final MonthlyInterestRateRepository repository;
    private final MainClient client;

    @Autowired
    public MonthlyInterestRateService(MonthlyInterestRateRepository repository, MainClient client) {
        this.repository = repository;
        this.client = client;
    }

    public void populate(int amount) {
        repository.saveAll(client.populate(amount).getResults());
    }

    public Page<MonthlyInterestRate> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public MonthlyInterestRate findByUUID(String uuid) {
        if (uuid.length() != UUID.randomUUID().toString().length()) {
            throw new InvalidQueryException("O UUID fornecido na URL não é válido.");
        }
        return repository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(uuid));
    }

    public Page<MonthlyInterestRate> findAllByYearMonth(String yearMonth, Pageable pageable) {
        if (!yearMonth.matches("\\d{4}-\\d{2}")) {
            throw new InvalidQueryException("O parâmetro de URL 'anoMes' deve seguir esse formato: yyyy-mm");
        }
        return repository.findAllBy_yearMonth(yearMonth, pageable);
    }

    public MonthlyInterestRate create(MonthlyInterestRate obj) {
            return repository.save(obj);
    }

    public MonthlyInterestRate update(MonthlyInterestRate obj, String uuid) {
        if (uuid.length() != UUID.randomUUID().toString().length()) {
            throw new InvalidQueryException("O UUID fornecido na URL não é válido.");
        }
        Optional<MonthlyInterestRate> updatedObj = repository.findById(uuid);
        copyProperties(obj,
                updatedObj.orElseThrow(() -> new ResourceNotFoundException(uuid)),
                getNullPropertyNames(obj));
            return repository.save(updatedObj.get());
    }

    @Transactional
    public void delete(String uuid) {
        if (uuid.length() != UUID.randomUUID().toString().length()) {
            throw new InvalidQueryException("O UUID fornecido na URL não é válido.");
        }
        MonthlyInterestRate obj = repository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(uuid));
        repository.delete(obj);
    }
}