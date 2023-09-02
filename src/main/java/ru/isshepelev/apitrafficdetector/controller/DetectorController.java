package ru.isshepelev.apitrafficdetector.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.apitrafficdetector.entity.Detector;
import ru.isshepelev.apitrafficdetector.service.DetectorService;

import java.util.List;

@RestController
@RequestMapping("/api/detector")
public class DetectorController {

    private final DetectorService detectorService;

    public DetectorController(DetectorService detectorService) {
        this.detectorService = detectorService;
    }


    @GetMapping("")
    public ResponseEntity<List<Detector>> getAllDetector(){
        List<Detector> detectorList = detectorService.getAllDetector();
        return new ResponseEntity<>(detectorList, HttpStatus.OK);
    }

//    @PutMapping("/initialized")
//    public ResponseEntity<Void> initialized(@RequestBody ){
//
//
//        return ResponseEntity.noContent().build();
//    }
}
