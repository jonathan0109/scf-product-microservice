package mx.unnamed.scf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScfProductMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScfProductMicroserviceApplication.class, args);
	}

}
