package com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response;

import com.doubleo.hospitalservice.domain.hospitalpolicy.domain.HospitalPolicy;
import java.time.LocalTime;

public record HospitalPolicyInfoResponse(int reserveDayOffset, LocalTime cutoffTime) {
    public static HospitalPolicyInfoResponse fromEntity(HospitalPolicy policy) {
        return new HospitalPolicyInfoResponse(policy.getReserveDayOffset(), policy.getCutoffTime());
    }
}
