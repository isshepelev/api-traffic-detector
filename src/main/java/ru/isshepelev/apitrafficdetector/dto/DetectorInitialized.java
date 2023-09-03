package ru.isshepelev.apitrafficdetector.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.isshepelev.apitrafficdetector.entity.Detector;

@Data
public class DetectorInitialized {
    @Size(min = 6,max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9-]*$")
    private String serialNumber;
    @Size(min = 1, max = 50)
    private  String model;
    @Valid
    private Detector.ConformityCertificate conformityCertificate;
}
