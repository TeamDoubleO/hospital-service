package com.doubleo.hospitalservice.domain.hospitalpolicy.controller;

import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request.HospitalPolicyInfoRequest;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalPolicyInfoResponse;
import com.doubleo.hospitalservice.domain.hospitalpolicy.service.HospitalPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policies")
@RequiredArgsConstructor
public class HospitalPolicyController {

    private final HospitalPolicyService hospitalPolicyService;

    @GetMapping("/me")
    public HospitalPolicyInfoResponse getMyHospitalPolicy(
            @RequestHeader("X-TENANT-ID") String tenantId) {
        return hospitalPolicyService.getPolicyByTenantId(tenantId);
    }

    @PatchMapping("/me")
    public void updateMyHospitalPolicy(
            @RequestHeader("X-TENANT-ID") String tenantId,
            @RequestBody HospitalPolicyInfoRequest request) {
        hospitalPolicyService.updatePolicyByTenantId(tenantId, request);
    }
}
