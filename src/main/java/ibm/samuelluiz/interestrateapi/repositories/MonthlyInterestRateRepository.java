package ibm.samuelluiz.interestrateapi.repositories;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MonthlyInterestRateRepository extends JpaRepository<MonthlyInterestRate, UUID> {
    List<MonthlyInterestRate> findAllBy_yearMonth(String yearMonth);
}
