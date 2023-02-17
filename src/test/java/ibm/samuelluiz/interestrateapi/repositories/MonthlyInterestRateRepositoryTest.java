package ibm.samuelluiz.interestrateapi.repositories;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;

import static ibm.samuelluiz.interestrateapi.common.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MonthlyInterestRateRepositoryTest {

    @Autowired
    private MonthlyInterestRateRepository repository;
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    public void saveEntity_ReturnsEntity() {
        MonthlyInterestRate entity = repository.save(ENTITY);

        MonthlyInterestRate sut = entityManager.find(MonthlyInterestRate.class, entity.get_uuid());

        assertThat(sut).isNotNull();
        assertThat(sut).isEqualTo(entity);
        assertThat(sut.get_interestRateByYear()).isEqualTo(ENTITY.get_interestRateByYear());
        assertThat(sut.get_interestRateByMonth()).isEqualTo(ENTITY.get_interestRateByMonth());
        assertThat(sut.get_modality()).isEqualTo(ENTITY.get_modality());
        assertThat(sut.get_month()).isEqualTo(ENTITY.get_month());
        assertThat(sut.get_position()).isEqualTo(ENTITY.get_position());
        assertThat(sut.get_eightDigitsCnpj()).isEqualTo(ENTITY.get_eightDigitsCnpj());
        assertThat(sut.get_financialInstitution()).isEqualTo(ENTITY.get_financialInstitution());
        assertThat(sut.get_uuid()).isEqualTo(entity.get_uuid());
    }

    @Test
    public void saveInvalidEntityThrowsException() {
        assertThatThrownBy(() -> repository.save(EMPTY_ENTITY));
        assertThatThrownBy(() -> repository.save(ENTITY_BLANK_STRINGS));
        assertThatThrownBy(() -> repository.save(ENTITY_NULL_STRINGS));
        assertThatThrownBy(() -> repository.save(ENTITY_NULL_VALUES));
        assertThatThrownBy(() -> repository.save(ENTITY_INVALID_CNPJ));
        assertThatThrownBy(() -> repository.save(ENTITY_INVALID_MONTH));
        assertThatThrownBy(() -> repository.save(ENTITY_INVALID_YEAR_MONTH));
    }

    @Test
    public void findEntityByIdReturnsEntity() {
        MonthlyInterestRate entity = repository.save(ENTITY);

        MonthlyInterestRate sut = repository.findById(entity.get_uuid()).get();

        assertThat(sut).isNotNull();
        assertThat(sut).isEqualTo(entity);
        assertThat(sut.get_interestRateByYear()).isEqualTo(entity.get_interestRateByYear());
        assertThat(sut.get_interestRateByMonth()).isEqualTo(entity.get_interestRateByMonth());
        assertThat(sut.get_modality()).isEqualTo(entity.get_modality());
        assertThat(sut.get_month()).isEqualTo(entity.get_month());
        assertThat(sut.get_position()).isEqualTo(entity.get_position());
        assertThat(sut.get_eightDigitsCnpj()).isEqualTo(entity.get_eightDigitsCnpj());
        assertThat(sut.get_financialInstitution()).isEqualTo(entity.get_financialInstitution());
        assertThat(sut.get_uuid()).isEqualTo(entity.get_uuid());
    }

    @Test
    public void findEntityByIdThrowsException() {
        assertThatThrownBy(() -> repository.findById(RANDOM_UUID).get());
    }

    @Test
    public void findAllEntitiesReturnsList() {
        repository.saveAll(List.of(ENTITY, ENTITY_2, ENTITY_3));

        List<MonthlyInterestRate> sut = repository.findAll();

        assertThat(sut.size()).isEqualTo(3);
    }

    @Test
    public void deleteEntityThenThrowsNoSuchElementWhenQuerying() {
        MonthlyInterestRate entity = repository.save(ENTITY);
        MonthlyInterestRate toBeDeleted = repository.findById(entity.get_uuid()).get();

        repository.delete(toBeDeleted);

        assertThatThrownBy(() -> repository.findById(toBeDeleted.get_uuid()).get())
                .isInstanceOf(NoSuchElementException.class);
    }


}
