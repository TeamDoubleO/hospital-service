package com.doubleo.hospitalservice.domain.area.controller;

import com.doubleo.hospitalservice.domain.area.dto.response.AreaInfoResponse;
import com.doubleo.hospitalservice.domain.area.service.AreaService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping
    @Operation(summary = "Get Areas by Building ID", description = "건물 ID로 구역 리스트 조회")
    public List<AreaInfoResponse> areaListGetByBuildingId(@RequestParam Long buildingId) {
        return areaService.getAreaListByBuildingId(buildingId);
    }
}
