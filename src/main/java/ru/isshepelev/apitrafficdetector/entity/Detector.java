package ru.isshepelev.apitrafficdetector.entity;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Document
@Data
public class Detector {

    @Id
    private String serialNumber;
    private State state;
    @Size(min = 1, max = 50)
    private String model;
    @Size(max = 512)
    private String address;
    private GpsCoordinate location;
    private Zone zone;
    private ConformityCertificate conformityCertificate;
    @Data
    public static class ConformityCertificate {
        @Size(max = 50)
        public String number;
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        public LocalDate expirationDate;
    }
}
