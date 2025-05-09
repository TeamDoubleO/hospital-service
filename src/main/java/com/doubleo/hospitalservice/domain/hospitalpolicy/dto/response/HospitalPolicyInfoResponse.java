package com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response;

import com.doubleo.hospitalservice.domain.hospitalpolicy.domain.HospitalPolicy;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class HospitalPolicyInfoResponse {

    private int reserveDayOffset;
    private LocalTime reserveTime;

    public static HospitalPolicyInfoResponse fromEntity(HospitalPolicy policy) {
        return HospitalPolicyInfoResponse.of(policy.getReserveDayOffset(), policy.getReserveTime());
    }
}
