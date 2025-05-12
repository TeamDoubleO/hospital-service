package com.doubleo.hospitalservice.domain.hospitalpolicy.controller;

import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request.HospitalPolicyInfoRequest;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalAvailableDateResponse;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalPolicyInfoResponse;
import com.doubleo.hospitalservice.domain.hospitalpolicy.service.HospitalPolicyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospitals/policies")
@RequiredArgsConstructor
public class HospitalPolicyController {

    private final HospitalPolicyService hospitalPolicyService;

    @GetMapping
    @Operation(summary = "Hospital Policy get API", description = "병원의 정책을 조회하기 위한 API")
    public HospitalPolicyInfoResponse myHospitalPolicyGet() {
        return hospitalPolicyService.getPolicyByTenantId();
    }

    @PatchMapping
    @Operation(summary = "Hospital Policy update API", description = "병원의 정책을 수정하기 위한 API")
    public void myHospitalPolicyUpdate(@Valid @RequestBody HospitalPolicyInfoRequest request) {
        hospitalPolicyService.updatePolicyByTenantId(request);
    }

    @GetMapping("/available-dates")
    @Operation(
            summary = "Hospital Available Dates get API",
            description = "병원의 정책에 따른 예약 가능 날짜를 조회하기 위한 API")
    public HospitalAvailableDateResponse availableDatesGet() {
        return hospitalPolicyService.getAvailableDateListByTenantId();
    }
}
