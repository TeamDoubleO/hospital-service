package com.doubleo.hospitalservice.domain.building.service;

import com.doubleo.hospitalservice.domain.building.dto.response.BuildingInfoResponse;
import java.util.List;

public interface BuildingService {
    List<BuildingInfoResponse> getBuildingsByTenantId();
}
