package ru.isshepelev.apitrafficdetector.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.isshepelev.apitrafficdetector.entity.GpsCoordinate;
import ru.isshepelev.apitrafficdetector.entity.Zone;

@Data
public class DetectorActivate {
    @Size(max = 512)
    private String address;
    @Valid
    private GpsCoordinate location;
    @Valid
    private Zone zone;
}
