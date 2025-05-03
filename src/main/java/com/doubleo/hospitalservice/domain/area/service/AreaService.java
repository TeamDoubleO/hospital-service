package com.doubleo.hospitalservice.domain.area.service;

import com.doubleo.hospitalservice.domain.area.dto.response.AreaInfoResponse;
import java.util.List;

public interface AreaService {
    List<AreaInfoResponse> getAreaListByBuildingId(Long buildingId);
}
