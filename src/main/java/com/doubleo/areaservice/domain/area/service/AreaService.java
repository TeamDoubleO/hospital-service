package com.doubleo.areaservice.domain.area.service;

import com.doubleo.areaservice.domain.area.domain.Area;
import com.doubleo.areaservice.domain.area.domain.AreaCategory;
import com.doubleo.areaservice.domain.area.domain.Building;
import com.doubleo.areaservice.domain.area.dto.request.AreaCreateRequest;
import com.doubleo.areaservice.domain.area.repository.AreaRepository;
import com.doubleo.areaservice.domain.area.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;
    private final BuildingRepository buildingRepository;

    // 새로운 Area 생성
    public void createArea(AreaCreateRequest request) {

        Building building =
                buildingRepository
                        .findById(request.buildingId())
                        .orElseThrow(() -> new RuntimeException("Building not found"));

        AreaCategory category = AreaCategory.valueOf(request.category().toUpperCase());

        areaRepository.save(Area.createArea(request.areaName(), building, category));
    }
}
