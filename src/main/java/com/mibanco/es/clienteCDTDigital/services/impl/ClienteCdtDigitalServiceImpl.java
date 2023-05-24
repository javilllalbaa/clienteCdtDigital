package com.mibanco.es.clienteCDTDigital.services.impl;

import com.mibanco.es.clienteCDTDigital.constants.Constans;
import com.mibanco.es.clienteCDTDigital.dao.contract.ClienteCdtDigitalArrayDAO;
import com.mibanco.es.clienteCDTDigital.dao.contract.ClienteCdtDigitalDAO;
import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import com.mibanco.es.clienteCDTDigital.services.contract.ClienteCdtDigitalService;
import com.mibanco.es.clienteCDTDigital.utils.ApplicationException;
import com.mibanco.es.clienteCDTDigital.utils.ClienteCdtDigitalValidator;
import com.mibanco.es.clienteCDTDigital.utils.ClienteDigitalMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@ApplicationScoped
public class ClienteCdtDigitalServiceImpl implements ClienteCdtDigitalService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteCdtDigitalServiceImpl.class);

    @Inject
    ClienteCdtDigitalDAO clienteCdtDigitalDAO;
    @Inject
    ClienteCdtDigitalArrayDAO clienteCdtDigitaArraylDAO;

    @Inject
    ClienteDigitalMapper clienteMapper;

    @Inject
    ClienteCdtDigitalValidator clienteCdtDigitalValidator;

    /*@Override
    public List<ClienteCDTDigitalType> obtenerClientes() {

        LOG.info("Inicia obtener Cliente en ClienteCdtDigitalSvcImpl");
        try {
            List<ClienteCdtDigitalEntity> entityList = clienteCdtDigitalDAO.listAll();

            LOG.info("Termina obtener Cliente en ClienteCdtDigitalSvcImpl");
            return entityList.stream()
                    .map(clienteMapper::clienteEntityToType)
                    .collect(Collectors.toList());
        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_OUTPUT_CLIENTES + e + " en ClienteCDTDigitalSvcImpl");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCdtDigitalSvcImpl");
        }

    }


    @Transactional
    @Override
    public ClienteCDTDigitalType crearClienteCDTDigital(ClienteCdtDigitalEntity clienteCDTDigitalEntity) {

        LOG.info("Inicia creación de datos crearClienteCDTDigitalSvcImpl");
        try {

            ClienteCDTDigitalType clienteCDTDigitalType = clienteMapper.clienteEntityToType(clienteCDTDigitalEntity);
            clienteCdtDigitalValidator.verificarDatosClienteCdtDigital(clienteCDTDigitalType);

            clienteCdtDigitalDAO.persist(clienteCDTDigitalEntity);

            LOG.info("Termina creación de datos crearClienteCDTDigitalSvcImpl");
            return clienteCDTDigitalType;

        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_OUTPUT_CLIENTES + e + " en ClienteCDTDigitalSvcImpl");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCdtDigitalSvcImpl");
        }
    }*/
    @Transactional
    @Override
    public ClienteCDTDigitalType crearClienteCDTDigital(ClienteCdtDigitalEntity clienteCDTDigitalEntity) {
        LOG.info("Inicia creación de datos crearClienteCDTDigitalSvcImpl");
        try {
            ClienteCDTDigitalType clienteCDTDigitalType = clienteMapper.clienteEntityToType(clienteCDTDigitalEntity);
            clienteCdtDigitaArraylDAO.crearClienteCDTDigital(clienteCDTDigitalType);

            return clienteCDTDigitalType;
        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_OUTPUT_CLIENTES + e + " en ClienteCDTDigitalSvcImpl");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCdtDigitalSvcImpl");
        }
    }

    public List<ClienteCDTDigitalType> obtenerClientes() {

        LOG.info("Inicia obtener Cliente en ClienteCdtDigitalSvcImpl");
        try {
            List<ClienteCDTDigitalType> entityList = clienteCdtDigitaArraylDAO.listAll();

            LOG.info("Termina obtener Cliente en ClienteCdtDigitalSvcImpl");
            return entityList;
        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_OUTPUT_CLIENTES + e + " en ClienteCDTDigitalSvcImpl");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " ClienteCdtDigitalSvcImpl");
        }
    }

    @Override
    public boolean validarExistenciaClienteCDT(ClienteCdtDigitalEntity clienteCDTDigitalEntity) {
        LOG.info("Inicia validar existencia Cliente CDT en ClienteCdtDigitalSvcImpl");
        try {
            boolean entityList = clienteCdtDigitaArraylDAO.validarCLiente(clienteCDTDigitalEntity);

            LOG.info("Termina validar existencia Cliente CDT en ClienteCdtDigitalSvcImpl");
            return entityList;
        } catch (ApplicationException e) {

            LOG.error(Constans.ERROR_OUTPUT_CLIENTES + e + " en validarExistenciaClienteCDTSvcImpl");
            throw new ApplicationException(Constans.ERROR_SERVICIO + e.getMessage() + " validarExistenciaClienteCDTSvcImpl");
        }
    }

}
