package com.doubleo.hospitalservice.domain.hospital.service;

import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalDetailInfoDto;
import com.doubleo.hospitalservice.domain.hospital.dto.response.HospitalInfoListDto;
import com.doubleo.hospitalservice.domain.hospital.repository.HospitalRepository;
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
        return hospitalRepository.findAll().stream().map(HospitalInfoListDto::from).toList();
    }

    public HospitalDetailInfoDto getHospitalById(Long id) {
        return HospitalDetailInfoDto.from(hospitalRepository.findById(id).get());
    }
}
