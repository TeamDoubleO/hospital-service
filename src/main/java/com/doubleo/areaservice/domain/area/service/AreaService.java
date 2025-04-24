package com.doubleo.areaservice.domain.area.service;

import com.doubleo.areaservice.domain.area.domain.Area;
import com.doubleo.areaservice.domain.area.domain.AreaCategory;
import com.doubleo.areaservice.domain.area.domain.Building;
import com.doubleo.areaservice.domain.area.dto.request.AreaCreateRequest;
import com.doubleo.areaservice.domain.area.dto.request.AreaUpdateRequest;
import com.doubleo.areaservice.domain.area.dto.response.AreaInfoResponse;
import com.doubleo.areaservice.domain.area.repository.AreaRepository;
import com.doubleo.areaservice.domain.area.repository.BuildingRepository;
import java.util.List;
import java.util.stream.Collectors;
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

    // 모든 구역 조회
    public List<AreaInfoResponse> getAllAreas() {
        return areaRepository.findAll().stream()
                .map(AreaInfoResponse::from)
                .collect(Collectors.toList());
    }

    // 구역 상세 조회
    public AreaInfoResponse getAreaById(Long id) {
        Area area =
                areaRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Area not found"));
        return AreaInfoResponse.from(area);
    }

    // 구역 삭제
    public void deleteArea(Long id) {
        final Area area =
                areaRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Area not found"));
        areaRepository.delete(area);
    }

    // 구역 정보 수정
    public void updateArea(Long id, AreaUpdateRequest request) {
        Area area =
                areaRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Area not found"));

        Building newBuilding =
                buildingRepository
                        .findById(request.buildingId())
                        .orElseThrow(() -> new RuntimeException("Building not found"));

        AreaCategory category = AreaCategory.valueOf(request.category().toUpperCase());

        area.updateName(request.name());
        area.updateBuilding(newBuilding);
        area.updateCategory(category);

        areaRepository.save(area);
    }

    // 건물 id 에 해당하는 구역 리스트 조회
    public List<AreaInfoResponse> getAreasByBuildingId(Long buildingId) {
        Building building =
                buildingRepository
                        .findById(buildingId)
                        .orElseThrow(() -> new RuntimeException("Building not found"));

        return areaRepository.findByBuilding(building).stream()
                .map(AreaInfoResponse::from)
                .collect(Collectors.toList());
    }
}
