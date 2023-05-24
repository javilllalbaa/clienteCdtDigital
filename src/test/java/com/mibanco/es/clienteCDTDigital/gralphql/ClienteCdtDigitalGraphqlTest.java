package com.mibanco.es.clienteCDTDigital.gralphql;

import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import com.mibanco.es.clienteCDTDigital.graphql.ClienteCdtDigitalGraphqController;
import com.mibanco.es.clienteCDTDigital.services.impl.ClienteCdtDigitalServiceImpl;
import com.mibanco.es.clienteCDTDigital.utils.ClienteDigitalMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteCdtDigitalGraphqlTest {

    @Mock
    private ClienteCdtDigitalServiceImpl clienteService;

    @Mock
    private ClienteDigitalMapper clienteMapper;

    @InjectMocks
    private ClienteCdtDigitalGraphqController clienteController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerClientesCDTDigital() {
        // Mock de datos
        List<ClienteCDTDigitalType> clientesMock = new ArrayList<>();
        // Agrega los datos de prueba a 'clientesMock'

        // Define el comportamiento esperado del servicio y el mapper
        when(clienteService.obtenerClientes()).thenReturn(clientesMock);
        when(clienteMapper.clienteTypeListToEntity(clientesMock)).thenReturn(new ArrayList<>());
        when(clienteMapper.clienteEntityToType(any(ClienteCdtDigitalEntity.class))).thenReturn(new ClienteCDTDigitalType());

        // Llama al método del controlador que deseas probar
        List<ClienteCDTDigitalType> result = clienteController.obtenerClientesCDTDigital();

        // Verifica los resultados
        assertEquals(clientesMock.size(), result.size());
    }

    @Test
    public void testCrearClienteCDTDigital() {
        // Mock de datos
        ClienteCDTDigitalType clienteMock = new ClienteCDTDigitalType();
        // Configura los datos de prueba en 'clienteMock'

        // Define el comportamiento esperado del servicio y el mapper
        when(clienteMapper.clienteTypeToEntity(clienteMock)).thenReturn(new ClienteCdtDigitalEntity());
        when(clienteService.crearClienteCDTDigital(any(ClienteCdtDigitalEntity.class))).thenReturn(clienteMock);

        // Llama al método del controlador que deseas probar
        ClienteCDTDigitalType result = clienteController.crearClienteCDTDigital(clienteMock);

        // Verifica los resultados
        assertEquals(clienteMock, result);
    }
}
