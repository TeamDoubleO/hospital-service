package com.doubleo.hospitalservice.domain.hospitalpolicy.service;

import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalPolicyInfoResponse;

public interface HospitalPolicyService {
    HospitalPolicyInfoResponse getPolicyByHospitalId(Long hospitalId);
}
