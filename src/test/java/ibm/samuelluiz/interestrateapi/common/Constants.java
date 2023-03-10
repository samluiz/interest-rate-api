package ibm.samuelluiz.interestrateapi.common;

import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateDTO;
import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Constants {

    public static final String BASE_URL = "https://olinda.bcb.gov.br/olinda/servico/taxaJuros/versao/v2/odata";

    public static final String RESPONSE = "{\n" +
            "  \"@odata.context\": \"https://was-p.bcnet.bcb.gov.br/olinda/servico/taxaJuros/versao/v2/odata$metadata#TaxasJurosMensalPorMes\",\n" +
            "  \"value\": [\n" +
            "    {\n" +
            "      \"Mes\": \"Jan-2023\",\n" +
            "      \"Modalidade\": \"FINANCIAMENTO IMOBILIÁRIO COM TAXAS REGULADAS - PRÉ-FIXADO\",\n" +
            "      \"Posicao\": 1,\n" +
            "      \"InstituicaoFinanceira\": \"BCO DO BRASIL S.A.\",\n" +
            "      \"TaxaJurosAoMes\": 0.00,\n" +
            "      \"TaxaJurosAoAno\": 0.00,\n" +
            "      \"cnpj8\": \"00000000\",\n" +
            "      \"anoMes\": \"2023-01\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final List<MonthlyInterestRate> EMPTY_LIST = new ArrayList<>();

    public static final MonthlyInterestRate EMPTY_ENTITY = new MonthlyInterestRate();

    public static final MonthlyInterestRate ENTITY = new MonthlyInterestRate("44e917a2-5bd8-442f-b244-6ced80586336",
            "FINANCIAMENTO",
            7,
            "ITAU UNIBANCO",
            0.85,
            7.43,
            "12345678",
            "Ago-2021",
            "2021-08");

    public static final MonthlyInterestRate ENTITY_2 = new MonthlyInterestRate(null,
            "CARTAO",
            2,
            "ITI UNIBANCO",
            0.85,
            7.43,
            "12345478",
            "Ago-2021",
            "2021-08");

    public static final MonthlyInterestRate ENTITY_3 = new MonthlyInterestRate(null,
            "CONSORCIO",
            2,
            "BRADESCO",
            0.85,
            7.43,
            "12315678",
            "Ago-2021",
            "2021-08");

    public static final List<MonthlyInterestRate> REAL_LIST = new ArrayList<>(List.of(ENTITY, ENTITY_2, ENTITY_3));


    public static final MonthlyInterestRate ENTITY_INVALID_CNPJ = new MonthlyInterestRate(null,
            "FINANCIAMENTO",
            7,
            "ITAU UNIBANCO",
            0.85,
            7.43,
            "12345678910",
            "Ago-2021",
            "2021-08");

    public static final MonthlyInterestRate ENTITY_INVALID_MONTH = new MonthlyInterestRate(null,
            "FINANCIAMENTO",
            7,
            "ITAU UNIBANCO",
            0.85,
            7.43,
            "12345678",
            "AGOSTO-2021",
            "2021-08");

    public static final MonthlyInterestRate ENTITY_INVALID_YEAR_MONTH = new MonthlyInterestRate(null,
            "FINANCIAMENTO",
            7,
            "ITAU UNIBANCO",
            0.85,
            7.43,
            "12345678",
            "Ago-2021",
            "2021-3313");

    public static final MonthlyInterestRate ENTITY_BLANK_STRINGS = new MonthlyInterestRate(null,
            "",
            7,
            "",
            0.85,
            7.43,
            "",
            "",
            "");

    public static final MonthlyInterestRate ENTITY_NULL_STRINGS = new MonthlyInterestRate(null,
            null,
            7,
            null,
            0.85,
            7.43,
            null,
            null,
            null);

    public static final MonthlyInterestRate ENTITY_NULL_VALUES = new MonthlyInterestRate(null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

    public static final MonthlyInterestRateDTO DTO = new MonthlyInterestRateDTO(
            "FINANCIAMENTO",
            7,
            "ITAU UNIBANCO",
            0.85,
            7.43,
            "12345678",
            "Ago-2021",
            "2021-08");

    public static final MonthlyInterestRateDTO DTO_2 = new MonthlyInterestRateDTO(
            "CARTAO",
            2,
            "ITI UNIBANCO",
            0.85,
            7.43,
            "12345478",
            "Ago-2021",
            "2021-08");

    public static final MonthlyInterestRateDTO DTO_3 = new MonthlyInterestRateDTO(
            "CONSORCIO",
            2,
            "BRADESCO",
            0.85,
            7.43,
            "12315678",
            "Ago-2021",
            "2021-08");

    public static final MonthlyInterestRateDTO DTO_4 = new MonthlyInterestRateDTO(
            "CARRO",
            2,
            "BRADESCO",
            0.85,
            7.43,
            "12315678",
            "Ago-2021",
            "2021-08");

    public static final MonthlyInterestRateDTO DTO_5 = new MonthlyInterestRateDTO(
            "CASA",
            2,
            "BRADESCO",
            0.85,
            7.43,
            "12315678",
            "Ago-2021",
            "2021-08");


    public static final MonthlyInterestRateList MONTHLY_INTEREST_RATE_LIST = new MonthlyInterestRateList(
            Set.of(DTO, DTO_2, DTO_3, DTO_4, DTO_5));

    public static final List<MonthlyInterestRate> FIVE_ITEMS_LIST = new ArrayList<>(List.of(new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate(),
            new MonthlyInterestRate()));

    public static final String RANDOM_UUID = UUID.randomUUID().toString();

    public static final String YEAR_MONTH = "2022-11";
}
