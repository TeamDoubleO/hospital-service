package com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import lombok.Getter;

@Getter
public class HospitalPolicyInfoRequest {
    @NotNull(message = "예약 가능일 수는 필수입니다.")
    private int reserveDayOffset;

    @NotNull(message = "예약 가능 시간은 필수입니다.")
    private LocalTime reserveTime;
}
