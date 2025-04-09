package com.tuvarna.mobilezonebackend.core.operations.mobile;

import com.tuvarna.mobilezonebackend.api.mobile.delete.DeleteMobileById;
import com.tuvarna.mobilezonebackend.api.mobile.delete.DeleteMobileByIdInput;
import com.tuvarna.mobilezonebackend.api.mobile.delete.DeleteMobileByIdResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import com.tuvarna.mobilezonebackend.persistence.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteMobileByIdOperation implements DeleteMobileById {
    private final MobileRepository mobileRepository;


    @Override
    public DeleteMobileByIdResult process(DeleteMobileByIdInput input) {
        Mobile mobile = getMobileById(input.getId());
        mobileRepository.delete(mobile);
        return buildResult();
    }

    private Mobile getMobileById(String id) {
        return mobileRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Mobile not found"));
    }

    public DeleteMobileByIdResult buildResult() {
        return DeleteMobileByIdResult.builder().build();
    }
}
