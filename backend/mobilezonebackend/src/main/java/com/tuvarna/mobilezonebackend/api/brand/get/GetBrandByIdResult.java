package com.tuvarna.mobilezonebackend.api.brand.get;

import com.tuvarna.mobilezonebackend.api.base.OperationResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetBrandByIdResult implements OperationResult {
    private Brand brand;
}
