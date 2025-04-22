package com.tuvarna.mobilezonebackend.api.mobile.edit;

import com.tuvarna.mobilezonebackend.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class EditMobileInput implements OperationInput {
    @UUID(message = "Invalid UUID format")
    @NotBlank(message = "Id cannot be null")
    private String id;

    @NotBlank(message = "Model cannot be null")
    @Size(min = 2, max = 50)
    private String model;

    @Positive(message = "Price must be positive")
    private Double price;

    @UUID(message = "Brand ID must be a valid UUID")
    @NotBlank(message = "Brand ID cannot be null")
    private String brandId;

    @NotBlank(message = "Operating system cannot be null")
    @Size(min = 2, max = 50)
    private String operatingSystem;

    @Positive(message = "RAM must be positive")
    private Integer ram;

    @Positive(message = "Storage must be positive")
    private Integer storage;

    @Positive(message = "Screen size must be positive")
    private Double screenSize;

    @NotBlank(message = "Processor cannot be null")
    @Size(min = 2, max = 50)
    private String processor;

    @NotBlank(message = "Resolution cannot be null")
    @Size(min = 2, max = 50)
    private String resolution;


    @NotBlank(message = "Dimensions cannot be null")
    private String dimensions;

    @Positive(message = "Weight must be positive")
    private Double weight;

    @NotBlank(message = "Build cannot be null")
    private String build;

    @NotBlank(message = "SIM cannot be null")
    private String sim;

    @NotBlank(message = "Display type cannot be null")
    private String displayType;

    @NotBlank(message = "GPU cannot be null")
    private String gpu;

    @NotBlank(message = "Main camera cannot be null")
    private String mainCamera;

    @NotBlank(message = "Main camera feature cannot be null")
    private String mainCameraFeature;

    @NotBlank(message = "Selfie camera cannot be null")
    private String selfieCamera;

    @NotBlank(message = "Battery type cannot be null")
    private String batteryType;

    @NotBlank(message = "Charging cannot be null")
    private String charging;

    @NotBlank(message = "Image cannot be null")
    private String image;

    @NotBlank(message = "Sensors cannot be null")
    private String sensors;

    @NotBlank(message = "Color cannot be null")
    private String color;

    private LocalDate releaseDate;
}
