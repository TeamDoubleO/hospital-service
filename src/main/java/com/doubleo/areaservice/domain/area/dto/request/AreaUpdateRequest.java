package com.doubleo.areaservice.domain.area.dto.request;

import com.doubleo.areaservice.domain.area.domain.AreaCategory;

public record AreaUpdateRequest(String name, Long buildingId, AreaCategory category) {}
