package com.doubleo.hospitalservice.domain.building.domain;

import com.doubleo.hospitalservice.domain.area.domain.Area;
import com.doubleo.hospitalservice.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
@Table(name = "building")
public class Building extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildingId;

    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Column(nullable = false)
    private String buildingName;

    @Column(nullable = false)
    private String buildingCode;

    @OneToMany(mappedBy = "building")
    private List<Area> areas;
}
