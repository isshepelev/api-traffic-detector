package ru.isshepelev.apitrafficdetector.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Zone {
    @NotNull
    private GpsCoordinate location;
    @Size(min = 1, max = 512)
    private String address;
    @Size(min = 2,max = 2)
    private List<Point> vrpDetectionArea;
}
