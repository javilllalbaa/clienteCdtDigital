package com.mibanco.es.clienteCDTDigital.grpc;

import com.mibanco.es.clienteCDTDigital.ClienteCDTServiceGrpcGrpc.ClienteCDTServiceGrpcImplBase;
import com.mibanco.es.clienteCDTDigital.ClienteCdtDigitalGrpc;
import com.mibanco.es.clienteCDTDigital.Creado;
import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import com.mibanco.es.clienteCDTDigital.services.impl.ClienteCdtDigitalServiceImpl;
import com.mibanco.es.clienteCDTDigital.utils.ApplicationException;
import com.mibanco.es.clienteCDTDigital.utils.ClienteCdtDigitalMapperGrpc;
import com.mibanco.es.clienteCDTDigital.constants.Constans;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GrpcService
public class ClienteCdtDigitalGrpcController extends ClienteCDTServiceGrpcImplBase {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteCdtDigitalGrpcController.class);
    @Inject
    ClienteCdtDigitalServiceImpl clienteCdtDigitalService;

    @Inject
    ClienteCdtDigitalMapperGrpc clienteCdtDigitalMapperGrpc;

    @Override
    @Blocking
    public void crearClienteCDT(ClienteCdtDigitalGrpc request, StreamObserver<Creado> responseObserver) {

        LOG.info("Inicia crear ClienteCdtDigital grpc");
        ClienteCdtDigitalEntity clienteCdtDigitalEntity = clienteCdtDigitalMapperGrpc.clienteGrpcToEntity(request);

        try {
            ClienteCDTDigitalType clienteCDTDigitalType = clienteCdtDigitalService.crearClienteCDTDigital(clienteCdtDigitalEntity);
            Creado response = Creado.newBuilder().setClienteCdtDigital(clienteCdtDigitalMapperGrpc.clienteCDTDigitalToGrpc(clienteCDTDigitalType)).build();
            responseObserver.onNext(response);

            LOG.info("Termina crear ClienteCdtDigital grpc");
            responseObserver.onCompleted();

        } catch (ApplicationException e) {
            LOG.info("Error crear ClienteCdtDigital grpc");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + "en crear ClienteCdtDigital grpc");
        }
    }

}
