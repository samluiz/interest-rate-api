package ibm.samuelluiz.interestrateapi.clients;

import ibm.samuelluiz.interestrateapi.common.Constants;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;
import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import ibm.samuelluiz.interestrateapi.services.MonthlyInterestRateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static ibm.samuelluiz.interestrateapi.common.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MainClientTest {

    @Mock
    private MainClient client;

    @Mock
    private MonthlyInterestRateRepository repository;

    @InjectMocks
    private MonthlyInterestRateService service;

    @Test
    public void populateWithDataFromExternalApiReturnsNothing() {
        when(client.populate(5)).thenReturn(MONTHLY_INTEREST_RATE_LIST);
        when(repository.saveAll(MONTHLY_INTEREST_RATE_LIST.getResults())).thenReturn(FIVE_ITEMS_LIST);

        service.populate(5);

        verify(client, times(1)).populate(5);
    }
}
