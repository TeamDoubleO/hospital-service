package com.doubleo.hospitalservice.domain.building.service;

import com.doubleo.hospitalservice.domain.building.dto.response.BuildingInfoResponse;
import com.doubleo.hospitalservice.domain.hospital.service.HospitalInternalService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
// 병원 야이디로 건물을 조회하는 서비스
// 병원 ID → 테넌트 ID 조회 → 해당 테넌트에 속한 건물 목록 반환
// 단일 도메인 로직이 아닌 Hospital + Building 도메인이 사용되므로 별도의 SearchService로 분리함
public class BuildingSearchService {
    private final HospitalInternalService hospitalInternalService;
    private final BuildingService buildingService;

    public List<BuildingInfoResponse> getBuildingsByHospitalId(Long hospitalId) {

        // hospitalInternalService에서 hospitalId에 해당하는 tenantId 조회
        Long tenantId = hospitalInternalService.getTenantIdByHospitalId(hospitalId);

        // tenantId를 기반으로 건물 리스트 조회 후 반환
        return buildingService.getBuildingsByTenantId(tenantId);
    }
}
