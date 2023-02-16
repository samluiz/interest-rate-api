package ibm.samuelluiz.interestrateapi.services;

import ibm.samuelluiz.interestrateapi.clients.MainClient;
import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonthlyInterestRateService {

    private MonthlyInterestRateRepository repository;
    private MainClient client;

    @Autowired
    public MonthlyInterestRateService(MonthlyInterestRateRepository repository, MainClient client) {
        this.repository = repository;
        this.client = client;
    }

    public void populate(Optional<Integer> limit) {
        repository.saveAll(client.populate(limit.orElse(50)).getResults());
    }
}
