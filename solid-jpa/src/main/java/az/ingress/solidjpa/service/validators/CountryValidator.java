package az.ingress.solidjpa.service.validators;

import az.ingress.solidjpa.service.DriverLicenseDto;
import org.springframework.stereotype.Component;

@Component
public class CountryValidator implements AbstractValidator {

    @Override
    public boolean isValid(DriverLicenseDto dto) {
        if (dto.getCountry().equals("Russia")) {
            return false;
        }
        return true;
    }
}
