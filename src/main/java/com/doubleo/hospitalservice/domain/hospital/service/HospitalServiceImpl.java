package com.doubleo.hospitalservice.domain.hospital.service;

import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalDetailInfoResponse;
import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalInfoListResponse;
import com.doubleo.hospitalservice.domain.hospital.repository.HospitalRepository;
import com.doubleo.hospitalservice.global.exception.CommonException;
import com.doubleo.hospitalservice.global.exception.errorcode.HospitalErrorCode;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    public List<HospitalInfoListResponse> getAllHospitals() {

        return hospitalRepository.findAll().stream().map(HospitalInfoListResponse::from).toList();
    }

    public HospitalDetailInfoResponse getHospitalById(Long id) {
        return hospitalRepository
                .findById(id)
                .map(HospitalDetailInfoResponse::from)
                .orElseThrow(() -> new CommonException(HospitalErrorCode.HOSPITAL_NOT_FOUND));
    }
}
