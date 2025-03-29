package com.tuvarna.mobilezone.persistence.repository;

import com.tuvarna.mobilezone.persistence.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
    Boolean existsByName(String name);
}
