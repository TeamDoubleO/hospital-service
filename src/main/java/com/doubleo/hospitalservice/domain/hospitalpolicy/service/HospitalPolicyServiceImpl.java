package com.doubleo.hospitalservice.domain.hospitalpolicy.service;

import com.doubleo.hospitalservice.domain.hospitalpolicy.domain.HospitalPolicy;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request.HospitalPolicyInfoRequest;
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
    public HospitalPolicyInfoResponse getPolicyByTenantId() {

        String tenantId = tenantValidator.getTenantId();

        HospitalPolicy policy =
                hospitalPolicyRepository
                        .getHospitalPolicyByTenantId(tenantId)
                        .orElseThrow(
                                () ->
                                        new CommonException(
                                                HospitalPolicyErrorCode.HOSPITAL_POLICY_NOT_FOUND));

        tenantValidator.validateTenant(policy);

        return HospitalPolicyInfoResponse.fromEntity(policy);
    }

    @Transactional
    public void updatePolicyByTenantId(HospitalPolicyInfoRequest request) {

        String tenantId = tenantValidator.getTenantId();

        HospitalPolicy policy =
                hospitalPolicyRepository
                        .getHospitalPolicyByTenantId(tenantId)
                        .orElseThrow(
                                () ->
                                        new CommonException(
                                                HospitalPolicyErrorCode.HOSPITAL_POLICY_NOT_FOUND));
        tenantValidator.validateTenant(policy);

        policy.updatePolicyInfo(request);
    }
}
