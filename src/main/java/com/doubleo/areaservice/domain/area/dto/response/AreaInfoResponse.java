package com.doubleo.areaservice.domain.area.dto.response;

import com.doubleo.areaservice.domain.area.domain.Area;
import lombok.Getter;

@Getter
public class AreaInfoResponse {
    private Long areaId;
    private String areaName;
    private String category;
    private Long buildingId;
    private String buildingName;

    public static AreaInfoResponse from(Area area) {
        AreaInfoResponse response = new AreaInfoResponse();
        response.areaId = area.getId();
        response.areaName = area.getAreaName();
        response.category = area.getCategory().name();
        response.buildingId = area.getBuilding().getId();
        response.buildingName = area.getBuilding().getBuildingName();
        return response;
    }
}
