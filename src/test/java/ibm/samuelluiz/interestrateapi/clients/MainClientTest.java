package ibm.samuelluiz.interestrateapi.clients;

import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import ibm.samuelluiz.interestrateapi.services.MonthlyInterestRateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static ibm.samuelluiz.interestrateapi.common.Constants.FIVE_ITEMS_LIST;
import static ibm.samuelluiz.interestrateapi.common.Constants.MONTHLY_INTEREST_RATE_LIST;
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
