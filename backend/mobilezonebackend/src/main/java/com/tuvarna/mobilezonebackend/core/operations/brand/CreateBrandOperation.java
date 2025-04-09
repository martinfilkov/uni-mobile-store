package com.tuvarna.mobilezonebackend.core.operations.brand;

import com.tuvarna.mobilezonebackend.api.brand.create.CreateBrand;
import com.tuvarna.mobilezonebackend.api.brand.create.CreateBrandInput;
import com.tuvarna.mobilezonebackend.api.brand.create.CreateBrandResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import com.tuvarna.mobilezonebackend.persistence.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateBrandOperation implements CreateBrand {
    private final BrandRepository brandRepository;

    @Override
    public CreateBrandResult process(CreateBrandInput input) {
        checkIfBrandExists(input.getName());
        Brand brand = createBrand(input);
        return buildResult(brand);
    }

    private void checkIfBrandExists(String brandName) {
        if (brandRepository.existsByName(brandName)) {
            throw new IllegalArgumentException("Brand already exists");
        }
    }

    private Brand createBrand(CreateBrandInput input) {
        Brand brand = Brand.builder()
                .name(input.getName())
                .country(input.getCountry())
                .establishedDate(input.getEstablishedDate())
                .build();
        return brandRepository.save(brand);
    }

    private CreateBrandResult buildResult(Brand brand) {
        return CreateBrandResult.builder()
                .id(brand.getId().toString())
                .build();
    }
}
