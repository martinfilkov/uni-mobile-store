package com.tuvarna.mobilezonebackend.core.operations.brand;

import com.tuvarna.mobilezonebackend.api.brand.get.GetBrandById;
import com.tuvarna.mobilezonebackend.api.brand.get.GetBrandByIdInput;
import com.tuvarna.mobilezonebackend.api.brand.get.GetBrandByIdResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import com.tuvarna.mobilezonebackend.persistence.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetBrandByIdOperation implements GetBrandById {
    private final BrandRepository brandRepository;
    @Override
    public GetBrandByIdResult process(GetBrandByIdInput input) {
        Brand brand = getBrandById(input.getId());
        return buildResult(brand);
    }

    private Brand getBrandById(String id) {
        return brandRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }

    private GetBrandByIdResult buildResult(Brand brand) {
        return GetBrandByIdResult.builder()
                .brand(brand)
                .build();
    }
}
