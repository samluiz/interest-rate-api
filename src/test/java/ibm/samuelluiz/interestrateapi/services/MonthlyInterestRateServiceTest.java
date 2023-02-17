package ibm.samuelluiz.interestrateapi.services;

import ibm.samuelluiz.interestrateapi.clients.MainClient;
import ibm.samuelluiz.interestrateapi.exceptions.services.InvalidQueryException;
import ibm.samuelluiz.interestrateapi.exceptions.services.ResourceNotFoundException;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.repositories.MonthlyInterestRateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static ibm.samuelluiz.interestrateapi.common.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MonthlyInterestRateServiceTest {

    @InjectMocks
    private MonthlyInterestRateService service;
    @Mock
    private MonthlyInterestRateRepository repository;

    @Mock
    private MainClient client;

    @Test
    public void populateDataReturnList() {
        when(repository.saveAll(any()))
                .thenReturn((List<MonthlyInterestRate>) MONTHLY_INTEREST_RATE_LIST.getResults());
        when(client.populate(5)).thenReturn(MONTHLY_INTEREST_RATE_LIST);

        List<MonthlyInterestRate> list = service.populate(5);

        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    public void findAllDataReturnsList() {
        Pageable pageable = PageRequest.of(0,5);
        Page<MonthlyInterestRate> result = new PageImpl<>(FIVE_ITEMS_LIST, pageable, 1);
        when(repository.findAll(any(Pageable.class))).thenReturn(result);

        Page<MonthlyInterestRate> returnPageable = service.findAll(pageable);

        assertThat(returnPageable.getTotalElements()).isEqualTo(5);
    }

    @Test
    public void findAllDataReturnsEmptyList() {
        Pageable pageable = PageRequest.of(0,5);
        Page<MonthlyInterestRate> result = new PageImpl<>(EMPTY_LIST, pageable, 0);
        when(repository.findAll(any(Pageable.class))).thenReturn(result);

        Page<MonthlyInterestRate> returnPageable = service.findAll(pageable);

        assertThat(returnPageable.getTotalElements()).isEqualTo(0);
    }

    @Test
    public void findAllByYearMonthReturnsList() {
        Pageable pageable = PageRequest.of(0,5);
        Page<MonthlyInterestRate> result = new PageImpl<>(FIVE_ITEMS_LIST, pageable, 1);
        when(repository.findAllBy_yearMonth(any(String.class), any(Pageable.class))).thenReturn(result);

        Page<MonthlyInterestRate> returnPageable = service.findAllByYearMonth(YEAR_MONTH, pageable);

        assertThat(returnPageable.getTotalElements()).isEqualTo(5);
    }

    @Test
    public void findAllByYearMonthReturnsEmptyList() {
        Pageable pageable = PageRequest.of(0,5);
        Page<MonthlyInterestRate> result = new PageImpl<>(EMPTY_LIST, pageable, 0);
        when(repository.findAllBy_yearMonth(any(String.class), any(Pageable.class))).thenReturn(result);

        Page<MonthlyInterestRate> returnPageable = service.findAllByYearMonth(YEAR_MONTH, pageable);

        assertThat(returnPageable.getTotalElements()).isEqualTo(0);
    }

    @Test
    public void findAllByYearMonthThrowsInvalidQueryException() {
        Pageable pageable = PageRequest.of(0,5);
        assertThrows(InvalidQueryException.class, () -> service.findAllByYearMonth("12-22", pageable));
    }

    @Test
    public void findByUUIDReturnsEntity() {
        when(repository.findById(any(String.class))).thenReturn(Optional.of(ENTITY));

        MonthlyInterestRate entity = service.findByUUID(RANDOM_UUID);

        assertThat(entity).isEqualTo(ENTITY);
    }

    @Test
    public void findByUUIDThrowsNotFoundException() {
        assertThrows(ResourceNotFoundException.class, () -> service.findByUUID(RANDOM_UUID));
    }

    @Test
    public void createEntityReturnsEntity() {
        when(repository.save(any(MonthlyInterestRate.class))).thenReturn(ENTITY);

        MonthlyInterestRate entity = service.create(new MonthlyInterestRate());

        assertThat(entity).isInstanceOf(MonthlyInterestRate.class);
        assertThat(entity).isEqualTo(ENTITY);
    }

    @Test
    public void updateEntityReturnsEntity() {
        when(repository.save(any(MonthlyInterestRate.class))).thenReturn(ENTITY);
        when(repository.findById(any(String.class))).thenReturn(Optional.of(ENTITY));

        MonthlyInterestRate entity = service.update(ENTITY, RANDOM_UUID);

        assertThat(entity).isInstanceOf(MonthlyInterestRate.class);
        assertThat(entity).isEqualTo(ENTITY);
    }

    @Test
    public void updateEntityThrowsNotFoundException() {
        assertThrows(ResourceNotFoundException.class, () -> service.update(ENTITY, RANDOM_UUID));
    }

    @Test
    public void deleteEntityReturnsNothing() {
        when(repository.findById(RANDOM_UUID)).thenReturn(Optional.of(ENTITY));
        doNothing().when(repository).delete(ENTITY);

        service.delete(RANDOM_UUID);

        verify(repository, times(1)).delete(ENTITY);
    }

    @Test
    public void deleteEntityThrowsInvalidQueryException() {
        assertThrows(InvalidQueryException.class, () -> service.delete(""));
    }

    @Test
    public void deleteEntityThrowsNotFoundException() {
        assertThrows(ResourceNotFoundException.class, () -> service.delete(RANDOM_UUID));
    }

}
