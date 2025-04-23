package com.doubleo.areaservice.domain.area.dto.request;

public record AreaCreateRequest(String areaName, Long buildingId, String category) {}
