package com.doubleo.hospitalservice.domain.hospitalpolicy.service;

import com.doubleo.hospitalservice.domain.hospitalpolicy.domain.HospitalPolicy;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalPolicyInfoResponse;
import com.doubleo.hospitalservice.domain.hospitalpolicy.repository.HospitalPolicyRepository;
import com.doubleo.hospitalservice.global.config.util.TenantValidator;
import com.doubleo.hospitalservice.global.exception.CommonException;
import com.doubleo.hospitalservice.global.exception.errorcode.HospitalPolicyErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalPolicyServiceImpl implements HospitalPolicyService {

    private final HospitalPolicyRepository hospitalPolicyRepository;
    private final TenantValidator<HospitalPolicy> tenantValidator;

    @Override
    public HospitalPolicyInfoResponse getPolicyByHospitalId(Long hospitalId) {
        // hospitalId로 정책 조회
        HospitalPolicy hospitalPolicy =
                hospitalPolicyRepository
                        .findById(hospitalId)
                        .orElseThrow(
                                () ->
                                        new CommonException(
                                                HospitalPolicyErrorCode.HOSPITAL_POLICY_NOT_FOUND));

        // 테넌트 검증
        tenantValidator.validateTenant(hospitalPolicy);

        return HospitalPolicyInfoResponse.fromEntity(hospitalPolicy);
    }
}
