package ru.isshepelev.apitrafficdetector.entity.dto;

import lombok.Data;
import ru.isshepelev.apitrafficdetector.entity.Detector;

@Data
public class DetectorInitialized {
    private String serialNumber;
    private  String model;
    private Detector.ConformityCertificate conformityCertificate;
}
