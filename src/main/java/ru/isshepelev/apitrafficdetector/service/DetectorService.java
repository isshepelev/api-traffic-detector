package ru.isshepelev.apitrafficdetector.service;

import ru.isshepelev.apitrafficdetector.entity.Detector;
import ru.isshepelev.apitrafficdetector.dto.DetectorActivate;
import ru.isshepelev.apitrafficdetector.dto.DetectorInitialized;

import java.util.List;

public interface DetectorService {
    List<Detector> getAllDetector();
    void initialize(DetectorInitialized detectorInitialized);
    void active(DetectorActivate detectorActivate, String serialNumber);
}
