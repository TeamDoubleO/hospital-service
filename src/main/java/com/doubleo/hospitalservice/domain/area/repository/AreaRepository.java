package com.doubleo.hospitalservice.domain.area.repository;

import com.doubleo.hospitalservice.domain.area.domain.Area;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findAllByBuilding_BuildingId(Long buildingId);

    Optional<Area> findByTenantIdAndAreaCode(String tenantId, String areaCode);
}
