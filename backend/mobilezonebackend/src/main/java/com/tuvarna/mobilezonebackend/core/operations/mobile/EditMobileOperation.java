package com.tuvarna.mobilezonebackend.core.operations.mobile;

import com.tuvarna.mobilezonebackend.api.mobile.edit.EditMobile;
import com.tuvarna.mobilezonebackend.api.mobile.edit.EditMobileInput;
import com.tuvarna.mobilezonebackend.api.mobile.edit.EditMobileResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import com.tuvarna.mobilezonebackend.persistence.repository.BrandRepository;
import com.tuvarna.mobilezonebackend.persistence.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditMobileOperation implements EditMobile {
    private final MobileRepository mobileRepository;
    private final BrandRepository brandRepository;

    @Override
    public EditMobileResult process(EditMobileInput input) {
        Mobile currentMobile = getMobileById(input.getId());
        checkIfMobileExists(input.getModel());
        Brand brand = getBrandById(input.getBrandId());
        Mobile updatedMobile = currentMobile.toBuilder()
                .model(input.getModel())
                .price(input.getPrice())
                .operatingSystem(input.getOperatingSystem())
                .ram(input.getRam())
                .storage(input.getStorage())
                .screenSize(input.getScreenSize())
                .processor(input.getProcessor())
                .resolution(input.getResolution())
                .dimensions(input.getDimensions())
                .weight(input.getWeight())
                .build(input.getBuild())
                .sim(input.getSim())
                .displayType(input.getDisplayType())
                .gpu(input.getGpu())
                .mainCamera(input.getMainCamera())
                .mainCameraFeature(input.getMainCameraFeature())
                .selfieCamera(input.getSelfieCamera())
                .batteryType(input.getBatteryType())
                .charging(input.getCharging())
                .image(input.getImage())
                .sensors(input.getSensors())
                .color(input.getColor())
                .releaseDate(input.getReleaseDate())
                .brand(brand)
                .build();
        Mobile savedMobile = mobileRepository.save(updatedMobile);
        return buildResult(savedMobile);
    }

    private Mobile getMobileById(String id) {
        return mobileRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Mobile not found"));
    }

    private Brand getBrandById(String id) {
        return brandRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }

    private void checkIfMobileExists(String model) {
        if (mobileRepository.existsByModel(model)) {
            throw new IllegalArgumentException("Mobile with model " + model + " already exists");
        }
    }

    private EditMobileResult buildResult(Mobile mobile) {
        return EditMobileResult.builder()
                .id(mobile.getId().toString())
                .build();
    }
}
