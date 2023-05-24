package com.mibanco.es.clienteCDTDigital.services.contract;

import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;

import java.util.List;

public interface ClienteCdtDigitalService   {

    List<ClienteCDTDigitalType> obtenerClientes();
    ClienteCDTDigitalType crearClienteCDTDigital(ClienteCdtDigitalEntity clienteCDTDigitalEntity);
    boolean validarExistenciaClienteCDT(ClienteCdtDigitalEntity clienteCDTDigitalEntity);
}
