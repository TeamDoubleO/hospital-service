package com.doubleo.hospitalservice.domain.hospitalpolicy.domain;

import com.doubleo.hospitalservice.domain.common.model.BaseEntity;
import com.doubleo.hospitalservice.domain.hospitalpolicy.dto.request.HospitalPolicyInfoRequest;
import jakarta.persistence.*;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_policy")
public class HospitalPolicy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_policy_id")
    private Long id;

    @Column(name = "hospital_policy_reserve_day_offset")
    private int reserveDayOffset;

    @Column(name = "hospital_policy_reserve_time")
    private LocalTime reserveTime;

    public void updatePolicyInfo(HospitalPolicyInfoRequest request) {
        this.reserveDayOffset = request.getReserveDayOffset();
        this.reserveTime = request.getReserveTime();
    }
}
