package bienestarestudiantil.bffweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//ENCUENTRA A LOS CLIENTES
@EnableFeignClients
@SpringBootApplication
public class BffwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffwebApplication.class, args);
	}

}