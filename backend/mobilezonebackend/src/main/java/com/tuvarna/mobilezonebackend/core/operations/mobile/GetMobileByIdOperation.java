package com.tuvarna.mobilezonebackend.core.operations.mobile;

import com.tuvarna.mobilezonebackend.api.mobile.get.GetMobileById;
import com.tuvarna.mobilezonebackend.api.mobile.get.GetMobileByIdInput;
import com.tuvarna.mobilezonebackend.api.mobile.get.GetMobileByIdResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import com.tuvarna.mobilezonebackend.persistence.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMobileByIdOperation implements GetMobileById {
    private final MobileRepository mobileRepository;

    @Override
    public GetMobileByIdResult process(GetMobileByIdInput input) {
        Mobile mobile = mobileRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new IllegalArgumentException("Mobile not found"));
        return buildResult(mobile);
    }

    private GetMobileByIdResult buildResult(Mobile mobile) {
        return GetMobileByIdResult.builder()
                .mobile(mobile)
                .build();
    }
}
