package ibm.samuelluiz.interestrateapi.services;

import ibm.samuelluiz.interestrateapi.clients.MainClient;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;
import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MonthlyInterestRateServiceTest {

    @InjectMocks
    private MonthlyInterestRateService service;
    @Mock
    private MonthlyInterestRateRepository repository;

    @Mock
    private MainClient client;

    @Test
    public void populateDataReturnList() {
        MonthlyInterestRateList mockClass = new MonthlyInterestRateList(List.of(new MonthlyInterestRate(),
                new MonthlyInterestRate(),
                new MonthlyInterestRate(),
                new MonthlyInterestRate(),
                new MonthlyInterestRate()));
        when(repository.saveAll(any()))
                .thenReturn((List<MonthlyInterestRate>) mockClass.getResults());
        when(client.populate(5)).thenReturn(mockClass);

        List<MonthlyInterestRate> list = service.populate(5);

        assertThat(list.size()).isGreaterThan(0);
        assertThat(list.size()).isEqualTo(5);
    }
}
