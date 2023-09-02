package ru.isshepelev.apitrafficdetector.service.impl;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import ru.isshepelev.apitrafficdetector.entity.Detector;
import ru.isshepelev.apitrafficdetector.entity.State;
import ru.isshepelev.apitrafficdetector.entity.dto.DetectorActivate;
import ru.isshepelev.apitrafficdetector.entity.dto.DetectorInitialized;
import ru.isshepelev.apitrafficdetector.repository.DetectorRepository;
import ru.isshepelev.apitrafficdetector.service.DetectorService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DetectorServiceImpl implements DetectorService {
    private final DetectorRepository detectorRepository;

    public DetectorServiceImpl(DetectorRepository detectorRepository) {
        this.detectorRepository = detectorRepository;
    }

    @Override
    public List<Detector> getAllDetector() {
        List<Detector> detectors =detectorRepository.findAll();
        if (detectors.isEmpty()){
            throw new NoSuchElementException();
        }
        return detectors;
    }

    @Override
    public void initialize(@Valid DetectorInitialized detectorInitialized) {
        if (detectorInitialized != null){
            Detector detector = new Detector();
            detector.setSerialNumber(detectorInitialized.getSerialNumber());
            detector.setModel(detectorInitialized.getModel());
            detector.setConformityCertificate(detectorInitialized.getConformityCertificate());

            detector.setState(State.NEW);
            detectorRepository.save(detector);
        }else new IllegalArgumentException();
    }

    @Override
    public void active(@Valid DetectorActivate detectorActivate,@Valid String serialNumber) {
        Optional<Detector> detectorOptional = detectorRepository.findById(serialNumber);
        if (detectorOptional.isPresent()){
            Detector detector = detectorOptional.get();
            detector.setAddress(detectorActivate.getAddress());
            detector.setLocation(detectorActivate.getLocation());
            detector.setZone(detectorActivate.getZone());
            detector.setState(State.ACTIVE);
            detectorRepository.save(detector);
        }else new IllegalArgumentException();

    }

    public void setting(@Valid String serialNumber) {
        Optional<Detector> detectorOptional = detectorRepository.findById(serialNumber);
        if (detectorOptional.isPresent()){
            Detector detector = detectorOptional.get();
            detector.setState(State.SETUP);
            detectorRepository.save(detector);
        }else new IllegalArgumentException();
    }

    public void reset(@Valid String serialNumber) {
        Optional<Detector> detectorOptional = detectorRepository.findById(serialNumber);
        if (detectorOptional.isPresent()){
            Detector detector = detectorOptional.get();
            detector.setState(State.NEW);
            detector.setAddress(null);
            detector.setLocation(null);
            detector.setZone(null);
            detectorRepository.save(detector);
        }else new IllegalArgumentException();
    }
}
