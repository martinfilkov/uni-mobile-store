package com.tuvarna.mobilezonebackend.core.operations.brand;

import com.tuvarna.mobilezonebackend.api.brand.delete.DeleteBrandById;
import com.tuvarna.mobilezonebackend.api.brand.delete.DeleteBrandByIdInput;
import com.tuvarna.mobilezonebackend.api.brand.delete.DeleteBrandByIdResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import com.tuvarna.mobilezonebackend.persistence.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteBrandByIdOperation implements DeleteBrandById {
    private final BrandRepository brandRepository;

    @Override
    public DeleteBrandByIdResult process(DeleteBrandByIdInput input) {
        Brand brand = getBrandById(input.getId());
        brandRepository.delete(brand);
        return buildResult();
    }

    private Brand getBrandById(String id) {
        return brandRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }

    private DeleteBrandByIdResult buildResult() {
        return DeleteBrandByIdResult.builder().build();
    }
}
