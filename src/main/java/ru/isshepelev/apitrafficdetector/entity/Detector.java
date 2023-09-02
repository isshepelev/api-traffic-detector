package ru.isshepelev.apitrafficdetector.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Detector {

    @Id
    private String serialNumber;
    private State state;
    private String model;
    private String address;
    private GpsCoordinate location;
    private Zone zone;
    private ConformityCertificate conformityCertificate;
    @Data
    public static class ConformityCertificate {
        public String number;
        public LocalDate expirationDate;
    }
}
