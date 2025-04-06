package com.tuvarna.mobilezonebackend.core.operations.brand;

import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import com.tuvarna.mobilezonebackend.persistence.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBrandsOperation {
    private final BrandRepository brandRepository;

    public List<Brand> process() {
        return brandRepository.findAll();
    }
}
