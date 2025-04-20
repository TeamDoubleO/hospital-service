package com.doubleo.areaproject.domain.area.domain;

import com.doubleo.areaproject.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class Area extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long id;
}
