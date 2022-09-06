package az.ingress.solidjpa.service;

import lombok.Data;

import java.util.Date;

@Data
public class DriverLicenseDto {

    private Long id;
    private Date issueDate;
    private Date expireDate;
    private String category;
    private String country;
}
