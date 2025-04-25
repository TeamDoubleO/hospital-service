package com.doubleo.areaservice.domain.area.dto.response;

import com.doubleo.areaservice.domain.area.domain.Area;

public record AreaInfoResponse(
        Long areaId, String areaName, String category, Long buildingId, String buildingName) {

    public static AreaInfoResponse from(Area area) {
        return new AreaInfoResponse(
                area.getId(),
                area.getAreaName(),
                area.getCategory().name(),
                area.getBuilding().getId(),
                area.getBuilding().getBuildingName());
    }
}
