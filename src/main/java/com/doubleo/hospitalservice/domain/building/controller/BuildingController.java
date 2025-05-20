package com.doubleo.hospitalservice.domain.building.controller;

import com.doubleo.hospitalservice.domain.building.dto.response.BuildingInfoResponse;
import com.doubleo.hospitalservice.domain.building.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospitals/buildings")
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping
    @Operation(
            summary = "Get Buildings by Hospital ID",
            description = "병원 ID를 기준으로 건물 리스트를 조회하는 API")
    public List<BuildingInfoResponse> buildingsGetByHospitalId() {
        return buildingService.getBuildingsByTenantId();
    }
}
