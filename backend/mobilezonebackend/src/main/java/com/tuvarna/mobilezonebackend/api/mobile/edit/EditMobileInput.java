package com.tuvarna.mobilezonebackend.api.mobile.edit;

import com.tuvarna.mobilezonebackend.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

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
}
