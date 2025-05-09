package com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class HospitalPolicyInfoRequest {
    private int reserveDayOffset;
    private LocalTime reserveTime;
}
