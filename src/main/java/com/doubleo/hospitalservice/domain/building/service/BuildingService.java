package com.doubleo.hospitalservice.domain.building.service;

import com.doubleo.hospitalservice.domain.building.dto.response.BuildingInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingService {
    List<BuildingInfoResponse> getBuildingsByTenantId();
    Page<BuildingInfoResponse> getPagedBuildingsByTenantId(Pageable pageable);
}
