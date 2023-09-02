package ru.isshepelev.apitrafficdetector.entity.dto;

import lombok.Data;
import ru.isshepelev.apitrafficdetector.entity.GpsCoordinate;
import ru.isshepelev.apitrafficdetector.entity.Zone;

@Data
public class DetectorActivate {
    private  String address;
    private GpsCoordinate location;
    private Zone zone;
}
