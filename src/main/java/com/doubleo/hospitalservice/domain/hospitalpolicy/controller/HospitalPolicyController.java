package com.doubleo.hospitalservice.domain.hospitalpolicy.controller;

import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request.HospitalPolicyInfoRequest;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalAvailableDateResponse;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalPolicyInfoResponse;
import com.doubleo.hospitalservice.domain.hospitalpolicy.service.HospitalPolicyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospitals/policies")
@RequiredArgsConstructor
public class HospitalPolicyController {

    private final HospitalPolicyService hospitalPolicyService;

    @GetMapping
    public HospitalPolicyInfoResponse myHospitalPolicyGet() {
        return hospitalPolicyService.getPolicyByTenantId();
    }

    @PatchMapping
    public void myHospitalPolicyUpdate(@Valid @RequestBody HospitalPolicyInfoRequest request) {
        hospitalPolicyService.updatePolicyByTenantId(request);
    }

    @GetMapping("/available-dates")
    public HospitalAvailableDateResponse availableDatesGet() {
        return hospitalPolicyService.getAvailableDateListByTenantId();
    }
}
