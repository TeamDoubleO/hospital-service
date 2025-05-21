package com.doubleo.hospitalservice.domain.area.controller;

import com.doubleo.hospitalservice.domain.area.dto.response.AreaInfoResponse;
import com.doubleo.hospitalservice.domain.area.service.AreaService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping("/{buildingId}/areas")
    @Operation(summary = "Get Areas by Building ID", description = "건물 ID로 구역 리스트 조회")
    public List<AreaInfoResponse> areaListGetByBuildingId(@PathVariable Long buildingId) {
        return areaService.getAreaListByBuildingId(buildingId);
    }
}
