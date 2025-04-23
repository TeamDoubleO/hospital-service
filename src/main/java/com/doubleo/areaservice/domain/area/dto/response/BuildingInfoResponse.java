package com.doubleo.areaservice.domain.area.dto.response;

import com.doubleo.areaservice.domain.area.domain.Building;
import lombok.Getter;

@Getter
public class BuildingInfoResponse {

    private Long buildingId;
    private String buildingName;

    public static BuildingInfoResponse from(Building building) {
        BuildingInfoResponse response = new BuildingInfoResponse();
        response.buildingId = building.getId();
        response.buildingName = building.getBuildingName();
        return response;
    }
}
