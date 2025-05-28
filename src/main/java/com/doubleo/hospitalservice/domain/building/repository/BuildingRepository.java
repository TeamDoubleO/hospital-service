package com.doubleo.hospitalservice.domain.building.repository;

import com.doubleo.hospitalservice.domain.building.domain.Building;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findAllByTenantId(String tenantId);

    Page<Building> findAllPagedByTenantId(String tenantId, Pageable pageable);

    Optional<Building> findByTenantIdAndBuildingCode(String tenantId, String buildingCode);
}
