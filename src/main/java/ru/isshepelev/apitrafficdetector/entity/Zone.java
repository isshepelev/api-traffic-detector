package ru.isshepelev.apitrafficdetector.entity;

import lombok.Data;

import java.util.List;

@Data
public class Zone {
    private GpsCoordinate location;
    private String address;
    private List<Point> vrpDetectionArea;
}
