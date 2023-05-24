package com.mibanco.es.clienteCDTDigital.gen.contract;

import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-24T10:13:09.004225-05:00[America/Bogota]")
public interface V1ClienteCDTDigitalESApi {

    @POST
    @Path("/ClienteCDTDigital")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    List<ClienteCDTDigitalType> crearClienteCdtDigital(@Valid ClienteCDTDigitalType clienteCDTDigitalType);

    @GET
    @Path("/obtenerClientes")
    @Produces({ "application/json" })
    List<ClienteCDTDigitalType> obtenerClienteCdtDigital();

    @POST
    @Path("/clienteCDT/validaExistencia")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Boolean validarExistenciaClienteCDT(@Valid ClienteCDTDigitalType clienteCDTDigitalType);
}
