package com.doubleo.areaservice.domain.area.controller;

import com.doubleo.areaservice.domain.area.dto.request.AreaCreateRequest;
import com.doubleo.areaservice.domain.area.dto.request.AreaUpdateRequest;
import com.doubleo.areaservice.domain.area.dto.response.AreaInfoResponse;
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
    @PostMapping
    public ResponseEntity<Void> createArea(@RequestBody AreaCreateRequest request) {
        areaService.createArea(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get All Areas", description = "모든 구역을 조회하는 API")
    @GetMapping
    public ResponseEntity<List<AreaInfoResponse>> findAllAreas() {
        return ResponseEntity.ok(areaService.findAllAreas());
    }

    @Operation(summary = "Get Area by ID", description = "ID로 구역을 조회하는 API")
    @GetMapping("/{id}")
    public ResponseEntity<AreaInfoResponse> findAreaById(@PathVariable Long id) {
        return ResponseEntity.ok(areaService.findAreaById(id));
    }

    @Operation(summary = "Delete Area by ID", description = "ID로 구역을 삭제하는 API")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
        areaService.deleteAreaById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update Area", description = "구역 정보를 수정하는 API")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArea(
            @PathVariable Long id, @RequestBody AreaUpdateRequest request) {
        areaService.updateArea(id, request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get Areas by Building ID", description = "건물 ID로 구역 리스트를 조회하는 API")
    @GetMapping("/building/{buildingId}")
    public ResponseEntity<List<AreaInfoResponse>> findAreasByBuildingId(
            @PathVariable Long buildingId) {
        return ResponseEntity.ok(areaService.findAreasByBuildingId(buildingId));
    }
}
