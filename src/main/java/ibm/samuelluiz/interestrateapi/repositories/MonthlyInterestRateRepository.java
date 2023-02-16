package ibm.samuelluiz.interestrateapi.repositories;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonthlyInterestRateRepository extends JpaRepository<MonthlyInterestRate, UUID> {
}
