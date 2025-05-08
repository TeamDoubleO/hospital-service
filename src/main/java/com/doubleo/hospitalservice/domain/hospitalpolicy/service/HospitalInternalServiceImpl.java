package com.doubleo.hospitalservice.domain.hospitalpolicy.service;

import com.doubleo.hospitalservice.domain.hospital.repository.HospitalRepository;
import com.doubleo.hospitalservice.domain.hospital.service.HospitalInternalService;
import com.doubleo.hospitalservice.global.exception.CommonException;
import com.doubleo.hospitalservice.global.exception.errorcode.HospitalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 병원 내부 서비스 구현체
@Service
@RequiredArgsConstructor
public class HospitalInternalServiceImpl implements HospitalInternalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public Long getTenantIdByHospitalId(Long hospitalId) {
        // 병원 아이디 -> tenant 아이디 조회
        return hospitalRepository
                .findById(hospitalId)
                .orElseThrow(() -> new CommonException(HospitalErrorCode.HOSPITAL_NOT_FOUND))
                .getTenantId();
    }
}
