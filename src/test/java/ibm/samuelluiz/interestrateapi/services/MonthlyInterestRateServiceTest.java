package ibm.samuelluiz.interestrateapi.services;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;
import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MonthlyInterestRateServiceTest {

    @InjectMocks
    private MonthlyInterestRateService service;
    @Mock
    private MonthlyInterestRateRepository repository;

    @Test
    public void populateDataReturnNothing() {
        when(any(MonthlyInterestRateList.class)
                .getResults())
                .thenReturn(List.of(any(MonthlyInterestRate.class)));
        when(repository.saveAll(any(MonthlyInterestRateList.class)
                .getResults()))
                .thenReturn(List.of(any(MonthlyInterestRate.class)));

        List<MonthlyInterestRate> list = service.populate();


    }
}
