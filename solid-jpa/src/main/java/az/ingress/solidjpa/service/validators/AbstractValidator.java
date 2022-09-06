package az.ingress.solidjpa.service.validators;

import az.ingress.solidjpa.service.DriverLicenseDto;

public interface AbstractValidator {
    boolean isValid(DriverLicenseDto dto);
}
