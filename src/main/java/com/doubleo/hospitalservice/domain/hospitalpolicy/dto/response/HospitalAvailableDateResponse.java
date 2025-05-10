package com.doubleo.hospitalservice.domain.hospitalpolicy.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;

public record HospitalAvailableDateResponse(
        @JsonFormat(pattern = "yyyy-MM-dd") List<LocalDate> availableDates) {}
