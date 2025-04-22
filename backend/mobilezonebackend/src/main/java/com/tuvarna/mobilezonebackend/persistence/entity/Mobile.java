package com.tuvarna.mobilezonebackend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@Entity
@Table(name = "mobiles")
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    //Dimensions fields
    @Column(name = "dimensions", nullable = false)
    private String dimensions;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "build", nullable = false)
    private String build;

    @Column(name = "sim", nullable = false)
    private String sim;

    //Display fields
    @Column(name = "resolution", nullable = false)
    private String resolution;

    @Column(name = "screen_size", nullable = false)
    private Double screenSize;

    @Column(name = "display_type", nullable = false)
    private String displayType;

    //Internals fields
    @Column(name = "gpu", nullable = false)
    private String gpu;

    @Column(name = "operation_system", nullable = false)
    private String operatingSystem;

    @Column(name = "camera", nullable = false)
    private String processor;

    //Camera fields
    @Column(name = "main_camera", nullable = false)
    private String mainCamera;

    @Column(name = "main_camera_feature", nullable = false)
    private String mainCameraFeature;

    @Column(name = "selfie_camera", nullable = false)
    private String selfieCamera;

    //Battery fields
    @Column(name = "battery_type", nullable = false)
    private String batteryType;

    @Column(name = "charging", nullable = false)
    private String charging;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "sensors", nullable = false)
    private String sensors;

    @Column(name = "color", nullable = false)
    private String color;

    //Other fields
    @Column(name = "model", nullable = false, unique = true)
    private String model;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "ram", nullable = false)
    private Integer ram;

    @Column(name = "storage", nullable = false)
    private Integer storage;
}
