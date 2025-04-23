package com.doubleo.areaservice.domain.area.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.doubleo.areaservice.domain.area.domain.Building;
import com.doubleo.areaservice.domain.area.dto.response.BuildingInfoResponse;
import com.doubleo.areaservice.domain.area.repository.BuildingRepository;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceTest {

    @Mock private BuildingRepository buildingRepository;

    @InjectMocks private BuildingService buildingService;

    private Building building1;
    private Building building2;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        building1 = new Building();

        Field buildingIdField = Building.class.getDeclaredField("buildingId");
        buildingIdField.setAccessible(true);
        buildingIdField.set(building1, 1L);

        Field buildingNameField = Building.class.getDeclaredField("buildingName");
        buildingNameField.setAccessible(true);
        buildingNameField.set(building1, "Building A");

        building2 = new Building();
        Field buildingIdField2 = Building.class.getDeclaredField("buildingId");
        buildingIdField2.setAccessible(true);
        buildingIdField2.set(building2, 2L);

        Field buildingNameField2 = Building.class.getDeclaredField("buildingName");
        buildingNameField2.setAccessible(true);
        buildingNameField2.set(building2, "Building B");
    }

    @Test
    void findAllBuilding_ShouldReturnBuildingInfoResponseList() {
        // given: mock buildingRepository.findAll() 메서드의 동작을 정의
        when(buildingRepository.findAll()).thenReturn(List.of(building1, building2));

        // when: buildingService.findAllBuilding() 호출
        List<BuildingInfoResponse> responseList = buildingService.findAllBuilding();

        // then: 반환된 리스트의 크기와 내용 확인
        assertNotNull(responseList);
        assertEquals(2, responseList.size());
        assertEquals(1L, responseList.get(0).getBuildingId());
        assertEquals("Building A", responseList.get(0).getBuildingName());
        assertEquals(2L, responseList.get(1).getBuildingId());
        assertEquals("Building B", responseList.get(1).getBuildingName());
    }

    @Test
    void findAllBuilding_ShouldReturnEmptyList_WhenNoBuildings() {
        // given: buildingRepository.findAll()이 빈 리스트를 반환하도록 mock 설정
        when(buildingRepository.findAll()).thenReturn(List.of());

        // when: buildingService.findAllBuilding() 호출
        List<BuildingInfoResponse> responseList = buildingService.findAllBuilding();

        // then: 빈 리스트가 반환되는지 확인
        assertNotNull(responseList);
        assertTrue(responseList.isEmpty());
    }
}
