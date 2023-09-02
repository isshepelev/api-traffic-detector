package ru.isshepelev.apitrafficdetector.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class Point {

    @Max(3840)
    @Min(0)
    private Integer x;

    @Max(3840)
    @Min(0)
    private Integer y;
}
