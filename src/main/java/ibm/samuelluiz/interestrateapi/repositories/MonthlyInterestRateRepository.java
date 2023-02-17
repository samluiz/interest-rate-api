package ibm.samuelluiz.interestrateapi.repositories;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyInterestRateRepository extends JpaRepository<MonthlyInterestRate, String> {
    Page<MonthlyInterestRate> findAllBy_yearMonth(String yearMonth, Pageable pageable);
}
