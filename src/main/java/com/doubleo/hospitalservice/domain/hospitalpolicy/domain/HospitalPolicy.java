package com.doubleo.hospitalservice.domain.hospitalpolicy.domain;

import com.doubleo.hospitalservice.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "hospital_policy")
public class HospitalPolicy extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_policy_id")
    private Long id;

    // 방문 예정 날짜 00:00 기준으로 N시간 전부터 신청 가능
    // hospital_policy_reserve_offset = 10이면 전날 14:00 부터 신청(발급) 가능
    @Column(name = "hospital_policy_reserve_offset")
    private Long hospitalPolicyReserveOffset;

    // 당일 방문 신청 가능 여부
    // hospital_policy_reserve_offset = 10, hospital_policy_allow_same_day = false이면
    // 전날 14:00 ~ 23:59 사이에 신청(발급) 가능
    @Column(name = "hospital_policy_allow_same_day")
    private Boolean hospitalPolicyAllowSameDay = true;
}
