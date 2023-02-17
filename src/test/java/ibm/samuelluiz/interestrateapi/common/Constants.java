package ibm.samuelluiz.interestrateapi.common;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Constants {
    public static final MonthlyInterestRateList MONTHLY_INTEREST_RATE_LIST = new MonthlyInterestRateList(List.of(new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate()));

    public static final List<MonthlyInterestRate> FIVE_ITEMS_LIST = new ArrayList<>(List.of(new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate()));

    public static final List<MonthlyInterestRate> EMPTY_LIST = new ArrayList<>();

    public static final MonthlyInterestRate ENTITY = new MonthlyInterestRate();

    public static final String RANDOM_UUID = UUID.randomUUID().toString();

    public static final String YEAR_MONTH = "2022-11";
}
