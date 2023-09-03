package ru.isshepelev.apitrafficdetector.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.apitrafficdetector.entity.Detector;
import ru.isshepelev.apitrafficdetector.dto.DetectorActivate;
import ru.isshepelev.apitrafficdetector.dto.DetectorInitialized;
import ru.isshepelev.apitrafficdetector.service.impl.DetectorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/detector")
public class DetectorController {

    private final DetectorServiceImpl detectorService;

    public DetectorController(DetectorServiceImpl detectorService) {
        this.detectorService = detectorService;
    }


    @GetMapping("")
    public ResponseEntity<List<Detector>> getAllDetector(){
        List<Detector> detectorList = detectorService.getAllDetector();
        return new ResponseEntity<>(detectorList, HttpStatus.OK);
    }

    @PutMapping("/initialized")
    public ResponseEntity<Void> initialized(@RequestBody @Valid DetectorInitialized detectorInitialized){
        detectorService.initialize(detectorInitialized);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/active/{serialNumber}")
    public ResponseEntity<Void> active(@RequestBody @Valid DetectorActivate detectorActivate,
                                       @PathVariable String serialNumber){
        detectorService.active(detectorActivate, serialNumber);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/setup/{serialNumber}")
    public ResponseEntity<Void> setup(@PathVariable String serialNumber){
        detectorService.setting(serialNumber);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/reset/{serialNumber}")
    public ResponseEntity<Detector> reset(@PathVariable String serialNumber){
        detectorService.reset(serialNumber);
        return ResponseEntity.noContent().build();
    }
}
