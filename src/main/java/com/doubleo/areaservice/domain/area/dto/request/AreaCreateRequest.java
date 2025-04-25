package com.doubleo.areaservice.domain.area.dto.request;

import com.doubleo.areaservice.domain.area.domain.AreaCategory;

public record AreaCreateRequest(String areaName, Long buildingId, AreaCategory category) {}
