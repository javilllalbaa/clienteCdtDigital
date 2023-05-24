package com.mibanco.es.clienteCDTDigital.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cabecera_salida_ibs")
public class CabeceraSalidaIBSEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rqUID;
    private Integer codError;
    private String descError;

}
