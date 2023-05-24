package com.mibanco.es.clienteCDTDigital.grpc;

import com.mibanco.es.clienteCDTDigital.ClienteCdtDigitalGrpc;
import com.mibanco.es.clienteCDTDigital.Creado;
import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import com.mibanco.es.clienteCDTDigital.services.impl.ClienteCdtDigitalServiceImpl;
import com.mibanco.es.clienteCDTDigital.utils.ClienteCdtDigitalMapperGrpc;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ClienteCdtDigitalGrpcTests {

    @Mock
    private ClienteCdtDigitalServiceImpl clienteCdtDigitalService;

    @Mock
    private ClienteCdtDigitalMapperGrpc clienteCdtDigitalMapperGrpc;

    @InjectMocks
    private ClienteCdtDigitalGrpcController clienteGrpcService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearClienteCDT() {
        // Mock de datos
        ClienteCdtDigitalGrpc requestMock = ClienteCdtDigitalGrpc.newBuilder().build();
        ClienteCDTDigitalType clienteCDTDigitalTypeMock = new ClienteCDTDigitalType();
        Creado responseMock = Creado.newBuilder().setClienteCdtDigital(requestMock).build();
        StreamObserver<Creado> responseObserverMock = mock(StreamObserver.class);

        // Define el comportamiento esperado del servicio y el mapper
        when(clienteCdtDigitalMapperGrpc.clienteGrpcToEntity(requestMock)).thenReturn(new ClienteCdtDigitalEntity());
        when(clienteCdtDigitalService.crearClienteCDTDigital(any(ClienteCdtDigitalEntity.class))).thenReturn(clienteCDTDigitalTypeMock);
        when(clienteCdtDigitalMapperGrpc.clienteCDTDigitalToGrpc(clienteCDTDigitalTypeMock)).thenReturn(requestMock);

        // Llama al método del controlador que deseas probar
        clienteGrpcService.crearClienteCDT(requestMock, responseObserverMock);

        // Verifica los resultados
        verify(responseObserverMock, times(1)).onNext(responseMock);
        verify(responseObserverMock, times(1)).onCompleted();

    }
}
