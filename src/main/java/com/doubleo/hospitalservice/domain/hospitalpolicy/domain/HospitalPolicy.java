package com.doubleo.hospitalservice.domain.hospitalpolicy.domain;

import com.doubleo.hospitalservice.domain.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalTime;
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

    @Column(name = "hospital_policy_reserve_day_offset")
    private int reserveDayOffset;

    @Column(name = "hospital_policy_reserve_time")
    private LocalTime reserveTime;
}
