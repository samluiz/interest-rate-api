package ibm.samuelluiz.interestrateapi.repositories;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static ibm.samuelluiz.interestrateapi.common.Constants.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MonthlyInterestRateRepositoryTest {

    @Autowired
    private MonthlyInterestRateRepository repository;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void createEntity_ReturnsEntity() {
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
    public void createInvalidEntityThrowsException() {
        assertThatThrownBy(() -> repository.save(EMPTY_ENTITY));
        assertThatThrownBy(() -> repository.save(ENTITY_BLANK_STRINGS));
        assertThatThrownBy(() -> repository.save(ENTITY_NULL_STRINGS));
        assertThatThrownBy(() -> repository.save(ENTITY_NULL_VALUES));
        assertThatThrownBy(() -> repository.save(ENTITY_INVALID_CNPJ));
        assertThatThrownBy(() -> repository.save(ENTITY_INVALID_MONTH));
        assertThatThrownBy(() -> repository.save(ENTITY_INVALID_YEAR_MONTH));
    }
}
