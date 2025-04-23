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
public class Building extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private Long id;

    @Column(name = "building_name")
    private String buildingName;

    @OneToMany(mappedBy = "building")
    private List<Area> areas = new ArrayList<>();
}
