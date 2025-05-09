package com.doubleo.hospitalservice.domain.area.grpc.server;

import com.doubleo.hospitalservice.domain.area.dto.response.AreaGrpcResponse;
import com.doubleo.hospitalservice.domain.area.repository.AreaRepository;
import com.doubleo.hospitalservice.global.exception.CommonException;
import com.doubleo.hospitalservice.global.exception.errorcode.AreaErrorCode;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.stream.Collectors;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AreaGrpcServiceImpl extends AreaServiceGrpc.AreaServiceImplBase {

    private final AreaRepository areaRepository;

    public AreaGrpcServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public void getAreaById(AreaIdRequest request, StreamObserver<AreaResponse> responseObserver) {
        areaRepository
                .findById(request.getAreaId())
                .map(AreaGrpcResponse::fromEntity)
                .ifPresentOrElse(
                        res -> {
                            AreaResponse resp =
                                    AreaResponse.newBuilder()
                                            .setAreaId(res.id())
                                            .setTenantId(res.tenantId())
                                            .setBuildingId(res.buildingId())
                                            .setAreaName(res.areaName())
                                            .setAreaCode(res.areaCode())
                                            .build();
                            responseObserver.onNext(resp);
                            responseObserver.onCompleted();
                        },
                        () -> {
                            responseObserver.onError(
                                    new CommonException(AreaErrorCode.AREA_NOT_FOUND));
                        });
    }

    @Override
    public void listAreas(
            AreaListRequest request, StreamObserver<AreaListResponse> responseObserver) {
        List<AreaGrpcResponse> all =
                areaRepository.findAll().stream()
                        .map(AreaGrpcResponse::fromEntity)
                        .collect(Collectors.toList());

        AreaListResponse response =
                AreaListResponse.newBuilder()
                        .addAllArea(
                                all.stream()
                                        .map(
                                                dto ->
                                                        AreaResponse.newBuilder()
                                                                .setAreaId(dto.id())
                                                                .setTenantId(dto.tenantId())
                                                                .setBuildingId(dto.buildingId())
                                                                .setAreaName(dto.areaName())
                                                                .setAreaCode(dto.areaCode())
                                                                .build())
                                        .collect(Collectors.toList()))
                        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
