package com.tuvarna.mobilezonebackend.core.operations.mobile;

import com.tuvarna.mobilezonebackend.api.mobile.create.CreateMobile;
import com.tuvarna.mobilezonebackend.api.mobile.create.CreateMobileInput;
import com.tuvarna.mobilezonebackend.api.mobile.create.CreateMobileResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import com.tuvarna.mobilezonebackend.persistence.repository.BrandRepository;
import com.tuvarna.mobilezonebackend.persistence.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateMobileOperation implements CreateMobile {
    private final MobileRepository mobileRepository;
    private final BrandRepository brandRepository;


    @Override
    public CreateMobileResult process(CreateMobileInput input) {
        Brand brand = getBrandIfExists(input.getBrandId());
        checkIfMobileExists(input.getModel());
        Mobile mobile = createMobile(input, brand);
        return buildResult(mobile);
    }

    private Brand getBrandIfExists(String id) {
        return brandRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }

    public void checkIfMobileExists(String model) {
        if (mobileRepository.existsByModel(model)) {
            throw new IllegalArgumentException("Mobile with model " + model + " already exists");
        }
    }

    public Mobile createMobile(CreateMobileInput input, Brand brand) {
        Mobile mobile = Mobile.builder()
                .model(input.getModel())
                .price(input.getPrice())
                .operatingSystem(input.getOperatingSystem())
                .ram(input.getRam())
                .storage(input.getStorage())
                .screenSize(input.getScreenSize())
                .processor(input.getProcessor())
                .resolution(input.getResolution())
                .brand(brand)
                .build();
        return mobileRepository.save(mobile);
    }

    private CreateMobileResult buildResult(Mobile mobile) {
        return CreateMobileResult.builder()
                .id(mobile.getId().toString())
                .build();
    }
}
