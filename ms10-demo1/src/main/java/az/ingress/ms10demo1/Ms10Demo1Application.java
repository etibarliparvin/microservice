package az.ingress.ms10demo1;

import az.ingress.ms10demo1.config.BankConfig;
import az.ingress.ms10demo1.config.BankConfig2;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Ms10Demo1Application implements CommandLineRunner {

//	private final BankConfig bankConfig;
	private final BankConfig2 bankConfig2;

	public static void main(String[] args) {
		SpringApplication.run(Ms10Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring now started " + bankConfig2);
	}
}
