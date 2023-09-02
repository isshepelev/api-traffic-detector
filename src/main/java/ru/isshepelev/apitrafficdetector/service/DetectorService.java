package ru.isshepelev.apitrafficdetector.service;

import org.springframework.stereotype.Service;
import ru.isshepelev.apitrafficdetector.entity.Detector;
import ru.isshepelev.apitrafficdetector.repository.DetectorRepository;

import java.util.List;

@Service
public class DetectorService {
    private final DetectorRepository detectorRepository;

    public DetectorService(DetectorRepository detectorRepository) {
        this.detectorRepository = detectorRepository;
    }

    public List<Detector> getAllDetector() {
        return detectorRepository.findAll();
    }
}
