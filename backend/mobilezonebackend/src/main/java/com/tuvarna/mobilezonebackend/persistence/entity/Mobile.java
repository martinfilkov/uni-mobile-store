package com.tuvarna.mobilezonebackend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "model", nullable = false, unique = true)
    private String model;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "operationSystem", nullable = false)
    private String operatingSystem;

    @Column(name = "ram", nullable = false)
    private Integer ram;

    @Column(name = "storage", nullable = false)
    private Integer storage;

    @Column(name = "battery", nullable = false)
    private Double screenSize;

    @Column(name = "camera", nullable = false)
    private String processor;

    @Column(name = "screenSize", nullable = false)
    private String resolution;
}
