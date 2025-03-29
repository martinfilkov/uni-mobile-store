package com.tuvarna.mobilezonebackend.api.mobile;

import com.tuvarna.mobilezonebackend.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateBrandInput implements OperationInput {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank(message = "Country cannot be null")
    @Size(min = 2, max = 50)
    private String country;

    @PastOrPresent(message = "Established date cannot be in the future")
    private LocalDateTime establishedDate;
}
