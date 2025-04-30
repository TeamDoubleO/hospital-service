package com.doubleo.hospitalservice.domain.building.service;

import com.doubleo.hospitalservice.domain.building.domain.Building;
import com.doubleo.hospitalservice.domain.building.dto.response.BuildingInfoResponse;
import com.doubleo.hospitalservice.domain.building.repository.BuildingRepository;
import com.doubleo.hospitalservice.global.exception.CommonException;
import com.doubleo.hospitalservice.global.exception.errorcode.BuildingErrorCode;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    // tenantId를 기반으로 소속 건물 리스트 조회
    @Override
    public List<BuildingInfoResponse> getBuildingsByTenantId(Long tenantId) {
        List<Building> buildings = buildingRepository.findAllByTenantId(tenantId);

        if (buildings.isEmpty()) {
            throw new CommonException(BuildingErrorCode.BUILDING_LIST_EMPTY);
        }

        return buildings.stream().map(BuildingInfoResponse::from).toList();
    }
}
