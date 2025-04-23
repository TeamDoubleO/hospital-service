package com.doubleo.areaservice.domain.area.repository;

import com.doubleo.areaservice.domain.area.domain.Area;
import com.doubleo.areaservice.domain.area.domain.Building;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findByBuilding(Building building);
}
