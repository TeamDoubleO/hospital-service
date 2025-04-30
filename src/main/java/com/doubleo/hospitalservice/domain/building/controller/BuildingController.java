package com.doubleo.hospitalservice.domain.building.controller;

import com.doubleo.hospitalservice.domain.building.dto.response.BuildingInfoResponse;
import com.doubleo.hospitalservice.domain.building.service.BuildingSearchService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buildings")
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingSearchService buildingSearchService;

    @GetMapping
    @Operation(
            summary = "Get Buildings by Hospital ID",
            description = "병원 ID를 기준으로 건물 리스트를 조회하는 API")
    public ResponseEntity<List<BuildingInfoResponse>> buildingsGetByHospitalId(
            @RequestParam Long hospitalId) {
        List<BuildingInfoResponse> buildings =
                buildingSearchService.getBuildingsByHospitalId(hospitalId);
        return ResponseEntity.ok(buildings);
    }
}
