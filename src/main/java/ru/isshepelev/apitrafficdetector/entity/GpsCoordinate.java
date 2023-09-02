package ru.isshepelev.apitrafficdetector.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class GpsCoordinate {

    @Min(-90)
    @Max(90)
    private Double latitude;

    @Min(-90)
    @Max(90)
    private Double longitude;
}
