package com.doubleo.areaservice.domain.area.dto.response;

import com.doubleo.areaservice.domain.area.domain.Building;

public record BuildingInfoResponse(Long buildingId, String buildingName) {

    public static BuildingInfoResponse from(Building building) {
        return new BuildingInfoResponse(building.getId(), building.getBuildingName());
    }
}
