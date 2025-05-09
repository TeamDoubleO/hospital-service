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

    @GetMapping
    public HospitalPolicyInfoResponse getMyHospitalPolicy() {
        return hospitalPolicyService.getPolicyByTenantId();
    }

    @PatchMapping
    public void updateMyHospitalPolicy(@RequestBody HospitalPolicyInfoRequest request) {
        hospitalPolicyService.updatePolicyByTenantId(request);
    }
}
