package com.doubleo.hospitalservice.domain.hospitalpolicy.service;

import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request.HospitalPolicyInfoRequest;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalPolicyInfoResponse;

public interface HospitalPolicyService {
    HospitalPolicyInfoResponse getPolicyByHospitalId(Long hospitalId);

    void updatePolicyByTenantId(String tenantId, HospitalPolicyInfoRequest request);
}
