package com.doubleo.hospitalservice.domain.hospital.controller;

import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalDetailInfoDto;
import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalInfoListDto;
import com.doubleo.hospitalservice.domain.hospital.service.HospitalService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping
    @Operation(summary = "All Hospitals get API", description = "모든 병원을 조회하기 위한 API")
    public List<HospitalInfoListDto> hospitalsGetAll() {
        return hospitalService.getAllHospitals();
    }

    @GetMapping(path = "/{hospitalId}")
    @Operation(summary = "Hospital Detail get API", description = "병원 상세 정보를 조회하기 위한 API")
    public HospitalDetailInfoDto hospitalDetailGet(@PathVariable Long hospitalId) {
        return hospitalService.getHospitalById(hospitalId);
    }
}
