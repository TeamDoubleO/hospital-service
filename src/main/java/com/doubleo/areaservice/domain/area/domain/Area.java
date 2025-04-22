package com.doubleo.areaservice.domain.area.domain;

import com.doubleo.areaservice.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Area extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @Column(name = "area_name", nullable = false)
    private String areaName;

    @Column(name = "area_category", length = 20)
    private String category;

    @OneToMany(mappedBy = "area")
    private List<EnterStatus> enterStatuses = new ArrayList<>();
}
