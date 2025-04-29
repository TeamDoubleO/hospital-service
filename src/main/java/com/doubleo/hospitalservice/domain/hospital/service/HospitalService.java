package com.doubleo.hospitalservice.domain.hospital.service;

import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalDetailInfoDto;
import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalInfoListDto;
import com.doubleo.hospitalservice.domain.hospital.repository.HospitalRepository;
import com.doubleo.hospitalservice.global.exception.CommonException;
import com.doubleo.hospitalservice.global.exception.errorcode.HospitalErrorCode;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional()
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public List<HospitalInfoListDto> getAllHospitals() {
        List<HospitalInfoListDto> hospitalList =
                hospitalRepository.findAll().stream().map(HospitalInfoListDto::from).toList();

        if (hospitalList.isEmpty()) {
            throw new CommonException(HospitalErrorCode.HOSPITAL_LIST_EMPTY);
        }

        return hospitalList;
    }

    public HospitalDetailInfoDto getHospitalById(Long id) {
        return hospitalRepository
                .findById(id)
                .map(HospitalDetailInfoDto::from)
                .orElseThrow(() -> new CommonException(HospitalErrorCode.HOSPITAL_NOT_FOUND));
    }
}
