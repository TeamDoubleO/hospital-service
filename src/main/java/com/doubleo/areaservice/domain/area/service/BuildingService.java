package com.doubleo.areaservice.domain.area.service;

import com.doubleo.areaservice.domain.area.dto.response.BuildingInfoResponse;
import com.doubleo.areaservice.domain.area.repository.BuildingRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public List<BuildingInfoResponse> findAllBuilding() {
        return buildingRepository.findAll().stream().map(BuildingInfoResponse::from).toList();
    }
}
