package com.tuvarna.mobilezonebackend.persistence.repository;

import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
    Boolean existsByName(String name);
}
