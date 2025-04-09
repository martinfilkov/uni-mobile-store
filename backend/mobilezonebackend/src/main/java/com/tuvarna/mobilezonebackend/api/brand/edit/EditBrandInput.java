package com.tuvarna.mobilezonebackend.api.brand.edit;

import com.tuvarna.mobilezonebackend.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
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
public class EditBrandInput implements OperationInput {
    @UUID(message = "Invalid UUID format")
    @NotBlank(message = "Id cannot be null")
    private String id;

    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank(message = "Country cannot be null")
    @Size(min = 2, max = 50)
    private String country;

    @PastOrPresent(message = "Established date cannot be in the future")
    private LocalDate establishedDate;
}
