package com.tuvarna.mobilezonebackend.api.brand.delete;

import com.tuvarna.mobilezonebackend.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class DeleteBrandByIdInput implements OperationInput {
    @UUID(message = "Invalid UUID format")
    @NotBlank(message = "Id cannot be null")
    private String id;
}
