package az.ingress.solidjpa.service;

import az.ingress.solidjpa.service.validators.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverLicenseValidatorImpl implements DriverLicenseValidator {

    private final List<AbstractValidator> validators;

    @Override
    public boolean isValid(DriverLicenseDto dto) {
        for (AbstractValidator validator : validators) {
            boolean result = validator.isValid(dto);
            if (!result) return false;
        }
        return true;
    }
}
