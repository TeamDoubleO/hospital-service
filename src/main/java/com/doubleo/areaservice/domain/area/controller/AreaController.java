package com.doubleo.areaservice.domain.area.controller;

import com.doubleo.areaservice.domain.area.dto.request.AreaCreateRequest;
import com.doubleo.areaservice.domain.area.dto.response.BuildingInfoResponse;
import com.doubleo.areaservice.domain.area.service.AreaService;
import com.doubleo.areaservice.domain.area.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/area")
@RequiredArgsConstructor
public class AreaController {

    private final BuildingService buildingService;
    private final AreaService areaService;

    @Operation(summary = "All Buildings get API", description = "모든 빌딩을 조회하기 위한 API")
    @GetMapping("/buildings")
    public List<BuildingInfoResponse> findAllBuilding() {
        return buildingService.findAllBuilding();
    }

    @Operation(summary = "Create Area API", description = "새로운 영역을 생성하기 위한 API")
    @PostMapping("/area")
    public ResponseEntity<Void> createArea(@RequestBody AreaCreateRequest request) {
        areaService.createArea(request);
        return ResponseEntity.ok().build();
    }
}
