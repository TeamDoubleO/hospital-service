package com.doubleo.hospitalservice.domain.hospital.dto.response;

import com.doubleo.hospitalservice.domain.hospital.domain.Hospital;
import io.swagger.v3.oas.annotations.media.Schema;

public record HospitalDetailInfoResponse(
        @Schema(description = "병원 아이디", example = "1") Long hospitalId,
        @Schema(description = "병원 이름", example = "서울아산병원") String hospitalName,
        @Schema(description = "병원 정책", example = "8") Long hospitalPolicy) {
    public static HospitalDetailInfoResponse from(Hospital hospital) {
        return new HospitalDetailInfoResponse(
                hospital.getId(), hospital.getHospitalName(), hospital.getHospitalPolicy());
    }
}
