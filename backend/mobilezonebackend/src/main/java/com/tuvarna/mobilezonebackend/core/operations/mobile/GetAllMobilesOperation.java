package com.tuvarna.mobilezonebackend.core.operations.mobile;

import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import com.tuvarna.mobilezonebackend.persistence.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMobilesOperation {
    private final MobileRepository mobileRepository;

    public List <Mobile> process() {
        return mobileRepository.findAll();
    }
}
