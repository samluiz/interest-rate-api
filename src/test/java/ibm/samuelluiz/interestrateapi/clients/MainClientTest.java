package ibm.samuelluiz.interestrateapi.clients;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import ibm.samuelluiz.interestrateapi.common.TestClient;
import ibm.samuelluiz.interestrateapi.models.dtos.MonthlyInterestRateList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import static ibm.samuelluiz.interestrateapi.common.Constants.BASE_URL;
import static ibm.samuelluiz.interestrateapi.common.Constants.RESPONSE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainClientTest {




    private TestClient client;

    @Test
    public void getDataFromApiReturnsOk() {
        this.buildFeignClient(new MockClient().ok(
                HttpMethod.GET,
                BASE_URL.concat("/TaxasJurosMensalPorMes"),
                RESPONSE
        ));

        MonthlyInterestRateList list = client.populate();

        assertThat(list).isNotNull();
        assertThat(list.getResults().size()).isEqualTo(1);
    }

    private void buildFeignClient(MockClient mockClient) {
        client = Feign.builder()
                .client(mockClient)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .target(TestClient.class, BASE_URL);
    }
}
