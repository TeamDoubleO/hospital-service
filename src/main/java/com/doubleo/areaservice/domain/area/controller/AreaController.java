package com.doubleo.areaservice.domain.area.controller;

import com.doubleo.areaservice.domain.area.dto.response.BuildingInfoResponse;
import com.doubleo.areaservice.domain.area.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
@RequiredArgsConstructor
public class AreaController {

    private final BuildingService buildingService;

    @Operation(summary = "All Buildings Group get API", description = "모든 빌딩을 조회하기 위한 API")
    @GetMapping("/buildings")
    public List<BuildingInfoResponse> findAllBuilding() {
        return buildingService.findAllBuilding();
    }
}
