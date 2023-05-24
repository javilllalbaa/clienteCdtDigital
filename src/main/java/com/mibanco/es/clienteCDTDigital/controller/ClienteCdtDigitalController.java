package com.mibanco.es.clienteCDTDigital.controller;

import com.mibanco.es.clienteCDTDigital.constants.Constans;
import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.contract.V1ClienteCDTDigitalESApi;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import com.mibanco.es.clienteCDTDigital.services.impl.ClienteCdtDigitalServiceImpl;
import com.mibanco.es.clienteCDTDigital.utils.ApplicationException;
import com.mibanco.es.clienteCDTDigital.utils.ClienteCdtDigitalValidator;
import com.mibanco.es.clienteCDTDigital.utils.ClienteDigitalMapper;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClienteCdtDigitalController implements V1ClienteCDTDigitalESApi {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteCdtDigitalController.class);
    @Inject
    ClienteCdtDigitalServiceImpl clienteCdtDigitalServiceImpl;
    @Inject
    ClienteDigitalMapper clienteMapper;

    @Inject
    ClienteCdtDigitalValidator clienteCdtDigitalValidator;

    @Override
    public List<ClienteCDTDigitalType> crearClienteCdtDigital(ClienteCDTDigitalType clienteCDTDigitalType) {

        LOG.info("Inicia crearClienteCdtDigitalController");
        try {
            ClienteCdtDigitalEntity clienteCDTDigitalEntity = clienteMapper.clienteTypeToEntity(clienteCDTDigitalType);
            clienteCDTDigitalType = clienteCdtDigitalServiceImpl.crearClienteCDTDigital(clienteCDTDigitalEntity);

            LOG.info("Termina crearClienteCdtDigitalController ");
            return List.of(clienteCDTDigitalType);

        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCDTDigitalController");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCDTDigitalController");

        }


    }



    @Override
    public List<ClienteCDTDigitalType> obtenerClienteCdtDigital( ) {
        LOG.info("Inicia crearClienteCdtDigitalController");
        try {

            List<ClienteCDTDigitalType> clienteCDTDigitalType = clienteCdtDigitalServiceImpl.obtenerClientes();

            LOG.info("Termina crearClienteCdtDigitalController ");
            return clienteCDTDigitalType;

        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCDTDigitalController");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCDTDigitalController");

        }
    }

    @Override
    public Boolean validarExistenciaClienteCDT(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia validarExistenciaClienteCDTController");
        try {

            ClienteCdtDigitalEntity clienteCDTDigitalEntity = clienteMapper.clienteTypeToEntity(clienteCDTDigitalType);
            boolean res = clienteCdtDigitalServiceImpl.validarExistenciaClienteCDT(clienteCDTDigitalEntity);

            LOG.info("Termina validarExistenciaClienteCDTController ");
            return res;

        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " validarExistenciaClienteCDTController");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " validarExistenciaClienteCDTController");

        }
    }


}
