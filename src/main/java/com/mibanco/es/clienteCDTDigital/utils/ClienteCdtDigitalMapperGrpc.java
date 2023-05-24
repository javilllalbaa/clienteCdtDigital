package com.mibanco.es.clienteCDTDigital.utils;

import com.mibanco.es.clienteCDTDigital.ClienteCdtDigitalGrpc;
import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteCdtDigitalMapperGrpc {

    public ClienteCdtDigitalGrpc clienteEntityToGrpc(ClienteCdtDigitalEntity clienteCDTDigitalEntity) {
        return new ModelMapper().map(clienteCDTDigitalEntity, ClienteCdtDigitalGrpc.class);
    }

    public ClienteCdtDigitalEntity clienteGrpcToEntity(ClienteCdtDigitalGrpc clienteCdtDigitalGrpc) {
        var retorno = new ModelMapper().map(clienteCdtDigitalGrpc, ClienteCdtDigitalEntity.class);
        System.out.println(" _8_8-*_8-*-8_*-8-*_*-8_*_8-8_*-8**   respuesta del modelMapper" + retorno);
        return retorno;
    }

    public ClienteCdtDigitalGrpc clienteCDTDigitalToGrpc(ClienteCDTDigitalType clienteCDTDigitalType) {
        return new ModelMapper().map(clienteCDTDigitalType, ClienteCdtDigitalGrpc.class);
    }


}
