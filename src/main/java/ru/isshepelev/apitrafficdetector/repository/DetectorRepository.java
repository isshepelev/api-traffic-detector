package ru.isshepelev.apitrafficdetector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.isshepelev.apitrafficdetector.entity.Detector;

@Repository
public interface DetectorRepository extends MongoRepository<Detector, String> {
}
