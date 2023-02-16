package ibm.samuelluiz.interestrateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InterestrateapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterestrateapiApplication.class, args);
	}

}
