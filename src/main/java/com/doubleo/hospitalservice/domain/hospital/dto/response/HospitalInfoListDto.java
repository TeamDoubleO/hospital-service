package com.doubleo.hospitalservice.domain.hospital.dto.response;

import com.doubleo.hospitalservice.domain.hospital.domain.Hospital;
import io.swagger.v3.oas.annotations.media.Schema;

public record HospitalInfoListDto(
        @Schema(description = "병원 아이디", example = "1") Long hospitalId,
        @Schema(description = "병원 이름", example = "서울아산병원") String hospitalName) {
    public static HospitalInfoListDto from(Hospital hospital) {
        return new HospitalInfoListDto(hospital.getId(), hospital.getHospitalName());
    }
}
