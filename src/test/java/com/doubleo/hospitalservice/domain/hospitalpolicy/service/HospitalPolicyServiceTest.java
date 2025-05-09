package com.doubleo.hospitalservice.domain.hospitalpolicy.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.doubleo.hospitalservice.domain.hospitalpolicy.domain.HospitalPolicy;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request.HospitalPolicyInfoRequest;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response.HospitalPolicyInfoResponse;
import com.doubleo.hospitalservice.domain.hospitalpolicy.repository.HospitalPolicyRepository;
import com.doubleo.hospitalservice.global.config.util.TenantValidator;
import com.doubleo.hospitalservice.global.exception.CommonException;
import com.doubleo.hospitalservice.global.exception.errorcode.HospitalPolicyErrorCode;
import java.time.LocalTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.util.ReflectionTestUtils;

class HospitalPolicyServiceImplTest {

    @InjectMocks private HospitalPolicyServiceImpl hospitalPolicyService;

    @Mock private HospitalPolicyRepository hospitalPolicyRepository;

    @Mock private TenantValidator<HospitalPolicy> tenantValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPolicyByTenantId_성공() {
        // given
        String tenantId = "101";
        HospitalPolicy policy =
                HospitalPolicy.builder()
                        .id(1L)
                        .reserveDayOffset(3)
                        .reserveTime(LocalTime.of(9, 0))
                        .build();

        when(hospitalPolicyRepository.getHospitalPolicyByTenantId(tenantId))
                .thenReturn(Optional.of(policy));

        // when
        HospitalPolicyInfoResponse response = hospitalPolicyService.getPolicyByTenantId(tenantId);

        // then
        assertEquals(3, response.getReserveDayOffset());
        assertEquals(LocalTime.of(9, 0), response.getReserveTime());
        verify(tenantValidator).validateTenant(policy);
    }

    @Test
    void getPolicyByTenantId_정책없음_예외() {
        // given
        String tenantId = "999";
        when(hospitalPolicyRepository.getHospitalPolicyByTenantId(tenantId))
                .thenReturn(Optional.empty());

        // when & then
        CommonException ex =
                assertThrows(
                        CommonException.class,
                        () -> hospitalPolicyService.getPolicyByTenantId(tenantId));
        assertEquals(HospitalPolicyErrorCode.HOSPITAL_POLICY_NOT_FOUND, ex.getErrorCode());
    }

    @Test
    void updatePolicyByTenantId_성공() {
        // given
        String tenantId = "101";
        HospitalPolicy policy =
                HospitalPolicy.builder()
                        .id(1L)
                        //                .tenantId(tenantId)
                        .reserveDayOffset(2)
                        .reserveTime(LocalTime.of(8, 0))
                        .build();

        HospitalPolicyInfoRequest request = new HospitalPolicyInfoRequest();
        ReflectionTestUtils.setField(request, "reserveDayOffset", 5);
        ReflectionTestUtils.setField(request, "reserveTime", LocalTime.of(11, 0));

        when(hospitalPolicyRepository.getHospitalPolicyByTenantId(tenantId))
                .thenReturn(Optional.of(policy));

        // when
        hospitalPolicyService.updatePolicyByTenantId(tenantId, request);

        // then
        assertEquals(5, policy.getReserveDayOffset());
        assertEquals(LocalTime.of(11, 0), policy.getReserveTime());
        verify(tenantValidator).validateTenant(policy);
    }

    @Test
    void updatePolicyByTenantId_정책없음_예외() {
        // given
        String tenantId = "404";
        HospitalPolicyInfoRequest request = new HospitalPolicyInfoRequest();

        when(hospitalPolicyRepository.getHospitalPolicyByTenantId(tenantId))
                .thenReturn(Optional.empty());

        // when & then
        CommonException ex =
                assertThrows(
                        CommonException.class,
                        () -> hospitalPolicyService.updatePolicyByTenantId(tenantId, request));
        assertEquals(HospitalPolicyErrorCode.HOSPITAL_POLICY_NOT_FOUND, ex.getErrorCode());
    }
}
