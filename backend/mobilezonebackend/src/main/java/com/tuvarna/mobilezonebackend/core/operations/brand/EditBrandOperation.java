package com.tuvarna.mobilezonebackend.core.operations.brand;

import com.tuvarna.mobilezonebackend.api.base.OperationProcessor;
import com.tuvarna.mobilezonebackend.api.brand.edit.EditBrand;
import com.tuvarna.mobilezonebackend.api.brand.edit.EditBrandInput;
import com.tuvarna.mobilezonebackend.api.brand.edit.EditBrandResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import com.tuvarna.mobilezonebackend.persistence.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditBrandOperation implements EditBrand{
    private final BrandRepository brandRepository;

    @Override
    public EditBrandResult process(EditBrandInput input) {
        Brand currentBrand = getBrandIfExists(input.getId());
        Brand updatedBrand = currentBrand.toBuilder()
                .name(input.getName())
                .country(input.getCountry())
                .establishedDate(input.getEstablishedDate())
                .build();
        Brand savedNewBrand = brandRepository.save(updatedBrand);
        return buildResult(savedNewBrand.getId());
    }

    private Brand getBrandIfExists(String id) {
        return brandRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }

    private EditBrandResult buildResult(UUID id) {
        return EditBrandResult.builder()
                .id(id.toString())
                .build();
    }
}
