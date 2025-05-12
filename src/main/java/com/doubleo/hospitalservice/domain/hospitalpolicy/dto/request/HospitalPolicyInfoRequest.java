package com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

public record HospitalPolicyInfoRequest(
        @NotNull(message = "예약 가능일 수는 필수입니다.") int reserveDayOffset,
        @NotNull(message = "예약 가능 시간은 필수입니다.") LocalTime cutoffTime) {}
