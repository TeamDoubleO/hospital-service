package com.doubleo.hospitalservice.domain.building.service;

import com.doubleo.hospitalservice.domain.building.dto.response.BuildingInfoResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuildingService {
    List<BuildingInfoResponse> getBuildingsByTenantId();

    Page<BuildingInfoResponse> getPagedBuildingsByTenantId(String keyword, Pageable pageable);
}
