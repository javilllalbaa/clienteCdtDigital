package com.mibanco.es.clienteCDTDigital.dao.contract;

import com.mibanco.es.clienteCDTDigital.dao.entity.ClienteCdtDigitalEntity;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteCdtDigitalArrayDAO {
     List<ClienteCDTDigitalType> lista=new ArrayList<ClienteCDTDigitalType>();

    public void crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        lista.add(clienteCDTDigitalType);
    }

    public List<ClienteCDTDigitalType> listAll() {

        return lista;
    }

    public boolean validarCLiente(ClienteCdtDigitalEntity clienteCDTDigitalEntity) {
        System.out.println("Javi...");
        System.out.println(clienteCDTDigitalEntity.getId());
        System.out.println(lista.stream().filter(p -> p.getId() == clienteCDTDigitalEntity.getId()).count());
        return lista.stream().filter(p -> p.getId() == clienteCDTDigitalEntity.getId()).count() > 0;
    }
}
