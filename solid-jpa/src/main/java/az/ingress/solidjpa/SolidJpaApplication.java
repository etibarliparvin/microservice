package az.ingress.solidjpa;

import az.ingress.solidjpa.service.DriverLicenseDto;
import az.ingress.solidjpa.service.DriverLicenseValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SolidJpaApplication implements CommandLineRunner {

    private final DriverLicenseValidator validator;

    public static void main(String[] args) {
        SpringApplication.run(SolidJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Started...");

        DriverLicenseDto dto = new DriverLicenseDto();
        dto.setId(2L);
        dto.setCountry("Russia");
        dto.setCategory("B");
        dto.setExpireDate(new Date());
        System.out.println(validator.isValid(dto));

        DriverLicenseDto dto1 = new DriverLicenseDto();
        dto1.setId(2L);
        dto1.setExpireDate(new Date());
        dto1.setCountry("Azerbaijan");
        dto1.setCategory("C");
        System.out.println(validator.isValid(dto1));
    }
}
