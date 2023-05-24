package com.mibanco.es.clienteCDTDigital.graphql;

import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import com.mibanco.es.clienteCDTDigital.services.impl.ClienteCdtDigitalServiceImpl;
import com.mibanco.es.clienteCDTDigital.utils.ApplicationException;
import com.mibanco.es.clienteCDTDigital.utils.ClienteDigitalMapper;
import com.mibanco.es.clienteCDTDigital.constants.Constans;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@GraphQLApi
public class ClienteCdtDigitalGraphqController {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteCdtDigitalGraphqController.class);
    @Inject
    ClienteCdtDigitalServiceImpl clienteService;

    @Inject
    ClienteDigitalMapper clienteMapper;

    @Query("clientesCdtDigital")
    @Description("obtener clientes mediante el dao")
    public List<ClienteCDTDigitalType> obtenerClientesCDTDigital() {

        LOG.info("Inicia obtener clientes en graphql controller");
        try {
            List<ClienteCDTDigitalType> clientes = clienteService.obtenerClientes();

            List<ClienteCdtDigitalEntity> listaClientes = clienteMapper.clienteTypeListToEntity(clientes);

            // Actualiza la lista de clientes con la lista mapeada de entidades
            clientes = listaClientes.stream()
                    .map(entity -> clienteMapper.clienteEntityToType(entity))
                    .collect(Collectors.toList());

            LOG.info("Termina obtener clientes en graphql controller");
            return clientes;
        } catch (Exception e) {
            LOG.error("Ocurrió un error al obtener clientes", e);
            throw new ApplicationException("ERROR_SERVICIO: " + e.getMessage() + " en ClienteCdtDigitalGraphqController");
        }
    }

    @Mutation("crearClienteCdtDigital")
    @Description("Crear clientes mediante el servicio")
    public ClienteCDTDigitalType crearClienteCDTDigital(@Valid ClienteCDTDigitalType clienteCDTDigitalType) {

        LOG.info("Inicia crear clientes en  graphql controller");
        try {
            ClienteCdtDigitalEntity clienteEntity = clienteMapper.clienteTypeToEntity(clienteCDTDigitalType);

            LOG.info("Termina crear clientes en  graphql controller");
            return clienteService.crearClienteCDTDigital(clienteEntity);

        } catch (ApplicationException e) {

            LOG.error("Ocurrió un error al crear un cliente", e);
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " en ClienteCdtDigitalGraphqController");
        }
    }


}
