package com.doubleo.areaservice.domain.area.domain;

import com.doubleo.areaservice.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "area_category", length = 20, nullable = false)
    private AreaCategory category;

    @OneToMany(
            mappedBy = "area",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<EnterStatus> enterStatuses = new ArrayList<>();

    @Builder(access = AccessLevel.PRIVATE)
    private Area(String areaName, Building building, AreaCategory category) {
        this.areaName = areaName;
        this.building = building;
        this.category = category;
    }

    public static Area createArea(String areaName, Building building, AreaCategory category) {
        return new Area(areaName, building, category);
    }
}
