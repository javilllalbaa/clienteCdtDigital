package com.mibanco.es.clienteCDTDigital.utils;


import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import com.mibanco.es.clienteCDTDigital.constants.Constans;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ClienteCdtDigitalValidator {

    @Inject
    Validator validator;

    public Response verificarDatosClienteCdtDigital(ClienteCDTDigitalType clienteCDTDigitalType)
            throws ApplicationException {

        if (clienteCDTDigitalType.getTelefonoPrincipal() == null) {
            throw new ApplicationException(Constans.ERROR_VALIDACION  + " Teléfono principal no puede estar vacio");
        }
        return Response.ok().build();
    }

}
