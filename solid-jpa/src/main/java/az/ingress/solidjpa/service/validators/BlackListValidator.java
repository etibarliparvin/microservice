package az.ingress.solidjpa.service.validators;

import az.ingress.solidjpa.service.DriverLicenseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlackListValidator implements AbstractValidator {

    private List blackList = List.of(1L, 2L, 4L);

    @Override
    public boolean isValid(DriverLicenseDto dto) {
        boolean contains = blackList.contains(dto.getId());
        return contains ? false : true;
    }
}
