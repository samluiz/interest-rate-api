package ibm.samuelluiz.interestrateapi.services;

import ibm.samuelluiz.interestrateapi.clients.MainClient;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlyInterestRateService {

    private final MonthlyInterestRateRepository repository;
    private final MainClient client;

    @Autowired
    public MonthlyInterestRateService(MonthlyInterestRateRepository repository, MainClient client) {
        this.repository = repository;
        this.client = client;
    }

    public List<MonthlyInterestRate> populate(int limit) {
        return repository.saveAll(client.populate(limit).getResults());
    }

    public List<MonthlyInterestRate> populate() {
        return repository.saveAll(client.populate(50).getResults());
    }
}
