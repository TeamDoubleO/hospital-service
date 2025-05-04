package com.doubleo.hospitalservice.domain.area.service;

import com.doubleo.hospitalservice.domain.area.dto.response.AreaInfoResponse;
import com.doubleo.hospitalservice.domain.area.repository.AreaRepository;
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
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;
    private final BuildingRepository buildingRepository;

    public List<AreaInfoResponse> getAreaListByBuildingId(Long buildingId) {

        // 실제로 존재하는 건물인지 확인
        if (!buildingRepository.existsById(buildingId)) {
            throw new CommonException(BuildingErrorCode.BUILDING_NOT_FOUND);
        }

        // 건물별 구역 조회
        return areaRepository.findAllByBuilding_BuildingId(buildingId).stream()
                .map(AreaInfoResponse::from)
                .toList();
    }
}
