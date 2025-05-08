package com.doubleo.hospitalservice.domain.hospitalpolicy.domain;

import com.doubleo.hospitalservice.domain.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "hospital_policy")
public class HospitalPolicy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_policy_id")
    private Long id;

    // 방문 예정 날짜 00:00 기준으로 N시간 전부터 신청 가능
    // reserveStartTime = 10:00이면 전날 14:00 부터 신청(발급) 가능
    @Column(name = "hospital_policy_reserve_start_time")
    private LocalDateTime reserveStartTime;

    // 방문 예정 다음 날짜 00:00 기준으로 N시간 전까지 신청 가능
    // reserveEndTime = 4:00이면 10이면 방문 당일 20:00 까지 신청(발급) 가능
    @Column(name = "hospital_policy_reserve_end_time")
    private LocalDateTime reserveEndTime;
}
