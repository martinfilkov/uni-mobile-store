package com.tuvarna.mobilezonebackend.persistence.repository;

import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MobileRepository extends JpaRepository<Mobile, UUID> {
    Optional<Mobile> findByModel(String model);
    Boolean existsByModel(String model);
}
