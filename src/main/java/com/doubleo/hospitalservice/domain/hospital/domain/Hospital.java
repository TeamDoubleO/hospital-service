package com.doubleo.hospitalservice.domain.hospital.domain;

import com.doubleo.hospitalservice.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Hospital extends BaseTimeEntity {
    @Id private Long id;
}
