package com.mibanco.es.clienteCDTDigital.utils;

import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteDigitalMapper {


    public ClienteCDTDigitalType clienteEntityToType(ClienteCdtDigitalEntity clienteCDTDigitalEntity) {
        return new ModelMapper().map(clienteCDTDigitalEntity, ClienteCDTDigitalType.class);
    }


    public List<ClienteCdtDigitalEntity> clienteTypeListToEntity(
            List<ClienteCDTDigitalType> clienteCDTDigitalTypeList) {
        return clienteCDTDigitalTypeList.stream().map(cliente -> clienteTypeToEntity(cliente))
                .collect(Collectors.toList());
    }


    public ClienteCdtDigitalEntity clienteTypeToEntity(ClienteCDTDigitalType clienteCDTDigitalType) {
        return new ModelMapper().map(clienteCDTDigitalType, ClienteCdtDigitalEntity.class);
    }

}
