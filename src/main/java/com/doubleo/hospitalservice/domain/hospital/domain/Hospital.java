package com.doubleo.hospitalservice.domain.hospital.domain;

import com.doubleo.hospitalservice.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Hospital extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long id;

    @Column(name = "tenent_id")
    private Long tenentId;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "hospital_policy")
    private String hospitalPolicy;
}
