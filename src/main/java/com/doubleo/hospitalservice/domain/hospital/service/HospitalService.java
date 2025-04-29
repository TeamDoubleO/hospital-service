package com.doubleo.hospitalservice.domain.hospital.service;

import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalDetailInfoResponse;
import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalInfoListResponse;
import java.util.List;

public interface HospitalService {

    List<HospitalInfoListResponse> getAllHospitals();

    HospitalDetailInfoResponse getHospitalById(Long id);
}
