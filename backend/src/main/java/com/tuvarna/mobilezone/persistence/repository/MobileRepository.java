package com.tuvarna.mobilezone.persistence.repository;

import com.tuvarna.mobilezone.persistence.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MobileRepository extends JpaRepository<Mobile, UUID> {
}
